package org.nayan.executer.completableFuture;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * ParallelApiCaller
 *
 * Demonstrates how to parallelize 100 API calls with:
 *  - controlled concurrency (fixed-thread executor used by HttpClient callbacks)
 *  - per-request timeout
 *  - retry (with small delay/backoff)
 *  - collecting successes and failures
 *
 * Requirements: Java 11+
 */
public class ParallelApiCaller {
    // configuration
    private static final int TOTAL_CALLS = 100;
    private static final int MAX_CONCURRENCY = 20;          // number of concurrent workers
    private static final int MAX_RETRIES = 2;               // number of retries (in addition to initial try)
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(5); // per-request timeout
    private static final Duration RETRY_DELAY = Duration.ofMillis(500);    // delay before retry

    public static void main(String[] args) throws Exception {
        // Executor used for HttpClient async callbacks and small processing tasks.
        // We limit it to MAX_CONCURRENCY so the callbacks don't overwhelm the system.
        ExecutorService httpExecutor = Executors.newFixedThreadPool(MAX_CONCURRENCY);

        // Scheduled executor used to implement retry delays
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Create an HttpClient that uses our executor for its asynchronous tasks
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .executor(httpExecutor)
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        try {
            // Prepare list of URLs to call. Replace with real endpoints as needed.
            // For demo we use https://postman-echo.com/get?i=<index> which echos back request info.
            List<URI> uris = new ArrayList<>(TOTAL_CALLS);
            for (int i = 1; i <= TOTAL_CALLS; i++) {
                // Example public echo endpoint — replace with your API URLs.
                uris.add(URI.create("https://postman-echo.com/get?i=" + i));
            }

            // For each URI, create a CompletableFuture that completes with HttpResponse<String>
            List<CompletableFuture<ApiResult>> futureResults = uris.stream()
                    .map(uri -> {
                        // fetch future
                        CompletableFuture<HttpResponse<String>> f =
                                fetchWithRetries(client, uri, MAX_RETRIES, REQUEST_TIMEOUT, scheduler);

                        // capture URI in final variable so lambda can use it safely
                        final String currentUri = uri.toString();

                        // map result → ApiResult
                        return f.thenApply(resp ->
                                        ApiResult.success(currentUri,
                                                resp.statusCode(), resp.body()))
                                .exceptionally(ex ->
                                        ApiResult.failure(currentUri, ex));
                    })

                    .collect(Collectors.toList());

            // Wait for all to finish
            CompletableFuture<Void> all = CompletableFuture
                    .allOf(futureResults.toArray(new CompletableFuture[0]));

            // block until all complete (or throw if interrupted)
            all.join();

            // Collect results
            List<ApiResult> results = futureResults.stream()
                    .map(CompletableFuture::join) // join is safe after all.join()
                    .collect(Collectors.toList());

            // Partition successes and failures
            List<ApiResult> successes = results.stream().filter(ApiResult::isSuccess).collect(Collectors.toList());
            List<ApiResult> failures = results.stream().filter(r -> !r.isSuccess()).collect(Collectors.toList());

            // Print summary
            System.out.println("Total requests: " + TOTAL_CALLS);
            System.out.println("Successes: " + successes.size());
            System.out.println("Failures: " + failures.size());

            // Show a few successful bodies (truncate for display)
            successes.stream().limit(5).forEach(r -> {
                System.out.println("SUCCESS: " + r.uri + " -> HTTP " + r.statusCode + " body-trimmed: " +
                        trim(r.body, 200));
            });

            // Show a few failures and their reasons
            failures.stream().limit(10).forEach(r -> {
                System.out.println("FAIL: " + r.uri + " -> " + r.errorSummary());
            });

        } finally {
            // clean shutdown
            scheduler.shutdownNow();
            httpExecutor.shutdownNow();
        }
    }

    /**
     * Fetches URI with retries. Returns a CompletableFuture that completes with HttpResponse<String>.
     *
     * Implementation notes:
     *  - Uses HttpClient.sendAsync(...) (non-blocking).
     *  - Applies per-request timeout via CompletableFuture.orTimeout (so it completes exceptionally on timeout).
     *  - If a call fails (exceptionally or non-2xx status if you choose), it will retry up to `retries` times.
     *  - Retry delay is implemented using ScheduledExecutorService to avoid blocking threads.
     */
    private static CompletableFuture<HttpResponse<String>> fetchWithRetries(
            HttpClient client,
            URI uri,
            int retries,
            Duration perRequestTimeout,
            ScheduledExecutorService scheduler) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .timeout(perRequestTimeout) // request-level timeout for some implementations; we also apply orTimeout below
                .GET()
                .build();

        // Attempt the request
        return client.sendAsync(request, BodyHandlers.ofString())
                // also enforce timeout at the CF level (safer because some connectors may ignore request timeout)
                .orTimeout(perRequestTimeout.toMillis(), TimeUnit.MILLISECONDS)
                .handle((response, throwable) -> {
                    if (throwable == null) {
                        // Success path (we could also check response.statusCode())
                        return CompletableFuture.completedFuture(response);
                    } else {
                        // Failure - decide whether to retry
                        if (retries <= 0) {
                            // no more retries: return a CF that completes exceptionally
                            CompletableFuture<HttpResponse<String>> failed = new CompletableFuture<>();
                            failed.completeExceptionally(throwable);
                            return failed;
                        } else {
                            // schedule a delayed retry and when the delay elapses, call fetchWithRetries recursively
                            CompletableFuture<HttpResponse<String>> delayed = new CompletableFuture<>();
                            scheduler.schedule(() -> {
                                fetchWithRetries(client, uri, retries - 1, perRequestTimeout, scheduler)
                                        .whenComplete((r, ex) -> {
                                            if (ex != null) delayed.completeExceptionally(ex);
                                            else delayed.complete(r);
                                        });
                            }, RETRY_DELAY.toMillis(), TimeUnit.MILLISECONDS);
                            return delayed;
                        }
                    }
                })
                // handle(...) returned a CompletableFuture<HttpResponse<String>> (possibly completed or delayed),
                // so flatten the nested CF using thenCompose-like behavior:
                .thenCompose(cf -> cf);
    }

    private static String trim(String s, int max) {
        if (s == null) return "null";
        return s.length() <= max ? s : s.substring(0, max) + "...(truncated)";
    }

    // small helper class to hold result metadata
    private static class ApiResult {
        final String uri;
        final boolean success;
        final int statusCode;
        final String body;
        final Throwable error;

        private ApiResult(String uri, boolean success, int statusCode, String body, Throwable error) {
            this.uri = uri;
            this.success = success;
            this.statusCode = statusCode;
            this.body = body;
            this.error = error;
        }

        static ApiResult success(String uri, int statusCode, String body) {
            return new ApiResult(uri, true, statusCode, body, null);
        }

        static ApiResult failure(String uri, Throwable error) {
            return new ApiResult(uri, false, -1, null, error);
        }

        boolean isSuccess() { return success; }

        String errorSummary() {
            if (error == null) return "Unknown error";
            if (error instanceof CompletionException) return "CompletionException: " + error.getCause();
            return error.getClass().getSimpleName() + ": " + error.getMessage();
        }
    }
}
