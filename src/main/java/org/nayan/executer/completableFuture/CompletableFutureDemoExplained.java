package org.nayan.executer.completableFuture;

import java.util.concurrent.*;

public class CompletableFutureDemoExplained {
    public static void main(String[] args) {

        try {
            // Creating a single-thread ThreadPoolExecutor
            // corePoolSize = 1, maxPoolSize = 1 → only 1 worker thread
            // Queue size = 10
            ThreadPoolExecutor poolExecutor =
                    new ThreadPoolExecutor(
                            1, 1,
                            1, TimeUnit.MINUTES,
                            new ArrayBlockingQueue<>(10),
                            Executors.defaultThreadFactory(),
                            new ThreadPoolExecutor.AbortPolicy()
                    );


            /* ---------------------------------------------------------
               1. supplyAsync() with custom executor
               ---------------------------------------------------------
               - supplyAsync() runs a Supplier in another thread.
               - Supplier returns a value.
               - Future result type = CompletableFuture<String>
             --------------------------------------------------------- */
            CompletableFuture<String> asyncTask1 =
                    CompletableFuture.supplyAsync(() -> {
                        return "Task Completed ";
                    }, poolExecutor);

            // get() blocks and returns the result of supplyAsync()
            System.out.println(asyncTask1.get());  // Output: Task Completed 


            /* ---------------------------------------------------------
               2. thenApply() for transforming result
               ---------------------------------------------------------
               - supplyAsync() returns "Hello "
               - thenApply() receives the previous value ("Hello ")
                 and returns a modified value.
             --------------------------------------------------------- */
            CompletableFuture<String> asyncTask2 =
                    CompletableFuture.supplyAsync(() -> {
                        return "Hello ";
                    }, poolExecutor)
                    .thenApply((String val) -> {
                        return val + "Nayan Kumar";   // append string
                    });

            System.out.println(asyncTask2.get());  // Output: Hello Nayan Kumar


            /* ---------------------------------------------------------
               3. Observing thread names with chained operations
               ---------------------------------------------------------
               - Both supplyAsync() and thenApply() use same pool thread
                 because you did NOT pass an executor to thenApplyAsync().
               - therefore both run in SAME thread.
             --------------------------------------------------------- */
            CompletableFuture<String> asyncTask3 =
                    CompletableFuture.supplyAsync(() -> {
                        // Prints worker thread name
                        return "Hello " + Thread.currentThread().getName();
                    }, poolExecutor)
                    .thenApply((String val) -> {
                        // thenApply runs in same thread pool executor
                        return val + " Nayan Kumar " + Thread.currentThread().getName();
                    });

            System.out.println(asyncTask3.get());
            // Example output:
            // Hello pool-1-thread-1 Nayan Kumar pool-1-thread-1

        } catch (Exception e) {
            // Empty catch is bad practice, but keeping it as in your code
            e.printStackTrace();
        }
    }
}
