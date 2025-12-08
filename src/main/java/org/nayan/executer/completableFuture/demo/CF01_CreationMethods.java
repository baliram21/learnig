package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Demonstrates creation methods:
 *  - runAsync()  -> fire-and-forget (returns CompletableFuture<Void>)
 *  - supplyAsync() -> returns a value (CompletableFuture<T>)
 *  - completedFuture() -> already completed, useful for tests/fallbacks
 */
public class CF01_CreationMethods {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // runAsync: executes a Runnable asynchronously; no result to return.
        // Useful for background work where you don't need a value back.
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(() ->
                        System.out.println("runAsync executed on " + Thread.currentThread().getName()), executor);

        // supplyAsync: executes a Supplier asynchronously and returns its result.
        // Equivalent to submitting a Callable and getting a Future, but with richer API.
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> {
                    // This supplier computes a value and completes the CF with it.
                    return "Hello from supplyAsync on " + Thread.currentThread().getName();
                }, executor);

        // completedFuture: returns a CompletableFuture that's already completed with given value.
        // No threads involved. Good for immediate/fast-return or mocks.
        CompletableFuture<String> f3 =
                CompletableFuture.completedFuture("Pre-completed value");

        // join() blocks until completion, but throws unchecked exceptions on failure (convenient in examples).
        f1.join();
        System.out.println(f2.join());
        System.out.println(f3.join());

        executor.shutdown();
    }
}
