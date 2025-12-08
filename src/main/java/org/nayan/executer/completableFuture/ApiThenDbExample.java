package org.nayan.executer.completableFuture;

import java.time.Duration;
import java.util.concurrent.*;

/**
 * ApiThenDbExample
 *
 * Demonstrates chaining an API call and then a dependent DB call using thenCompose().
 *
 * Flow:
 *  1. call apiClient.fetchUserIdFromApi(username) -> CompletableFuture<Integer>
 *  2. thenCompose(userId -> dbClient.fetchUserDetails(userId)) -> CompletableFuture<User>
 *  3. handle success / exceptions
 *
 * Key points:
 *  - thenCompose() is used because the DB call returns a CompletableFuture.
 *    thenCompose flattens Future<Future<T>> -> Future<T>.
 *  - DB calls which are blocking should run on a dedicated ExecutorService.
 */
public class ApiThenDbExample {

    // Simple DTO for demonstration
    static class User {
        final int id;
        final String username;
        final String email;

        User(int id, String username, String email) {
            this.id = id;
            this.username = username;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{id=" + id + ", username='" + username + "', email='" + email + "'}";
        }
    }

    /**
     * Simulated ApiClient.
     *
     * In production you would use HttpClient.sendAsync(...) or a reactive client.
     * Here we simulate latency using supplyAsync+sleep.
     */
    static class ApiClient {
        private final ExecutorService apiExecutor;

        ApiClient(ExecutorService apiExecutor) {
            this.apiExecutor = apiExecutor;
        }

        /**
         * Simulate an API call that returns a userId for a given username.
         * Returns CompletableFuture<Integer>.
         */
        CompletableFuture<Integer> fetchUserIdFromApi(String username) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    // Simulate network latency
                    Thread.sleep(400);
                    // In a real call: parse JSON response and extract userId
                    // For demo: return a deterministic userId from username hash
                    int userId = Math.abs(username.hashCode() % 1000) + 1;
                    System.out.println("[API] resolved username='" + username + "' -> userId=" + userId
                            + " on thread " + Thread.currentThread().getName());
                    return userId;
                } catch (InterruptedException e) {
                    throw new CompletionException(e);
                }
            }, apiExecutor);
        }
    }

    /**
     * Simulated Database client.
     *
     * IMPORTANT: Real DB calls (JDBC) are blocking and should run on a dedicated executor.
     * For example:
     *
     * CompletableFuture<User> cf = CompletableFuture.supplyAsync(() -> {
     *     // do JDBC query using a connection from DataSource
     *     // map ResultSet -> User
     * }, dbExecutor);
     */
    static class DatabaseClient {
        private final ExecutorService dbExecutor;

        DatabaseClient(ExecutorService dbExecutor) {
            this.dbExecutor = dbExecutor;
        }

        CompletableFuture<User> fetchUserDetails(int userId) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    // Simulate DB latency
                    Thread.sleep(300);
                    // Simulated DB lookup
                    String username = "user" + userId;
                    String email = username + "@example.com";
                    System.out.println("[DB] fetched details for userId=" + userId
                            + " on thread " + Thread.currentThread().getName());
                    return new User(userId, username, email);
                } catch (InterruptedException e) {
                    throw new CompletionException(e);
                }
            }, dbExecutor);
        }
    }

    public static void main(String[] args) {
        // Executors: separate pools for API and DB
        ExecutorService apiExecutor = Executors.newFixedThreadPool(4, runnable -> {
            Thread t = new Thread(runnable);
            t.setName("api-exec-" + t.getId());
            return t;
        });
        ExecutorService dbExecutor = Executors.newFixedThreadPool(4, runnable -> {
            Thread t = new Thread(runnable);
            t.setName("db-exec-" + t.getId());
            return t;
        });

        ApiClient apiClient = new ApiClient(apiExecutor);
        DatabaseClient dbClient = new DatabaseClient(dbExecutor);

        String username = "balir";

        // Example: chain API -> DB using thenCompose
        CompletableFuture<User> userFuture = apiClient.fetchUserIdFromApi(username)
                // thenCompose expects a function that returns CompletableFuture<?>
                // here we use the API result (userId) to call the DB (which returns CompletableFuture<User>)
                .thenCompose(userId -> {
                    // You can add logging / validation here before calling DB
                    if (userId <= 0) {
                        // return a failed CompletableFuture if input invalid
                        CompletableFuture<User> failed = new CompletableFuture<>();
                        failed.completeExceptionally(new IllegalArgumentException("Invalid userId: " + userId));
                        return failed;
                    }
                    return dbClient.fetchUserDetails(userId);
                })
                // Add a timeout so the overall chain doesn't wait forever.
                .orTimeout(5, TimeUnit.SECONDS)
                // Handle exceptions and return a fallback User (optional)
                .exceptionally(ex -> {
                    System.err.println("[ERROR] failed to fetch user: " + ex);
                    // fallback or rethrow. We return null here to indicate failure to caller.
                    return null;
                });

        // Block and get result for demo purposes. In production prefer non-blocking continuation.
        User user = null;
        try {
            user = userFuture.get(); // or join()
        } catch (ExecutionException | InterruptedException e) {
            System.err.println("Failed to complete: " + e);
        }

        System.out.println("Final result -> " + user);

        // Clean shutdown of executors
        apiExecutor.shutdown();
        dbExecutor.shutdown();
    }
}
