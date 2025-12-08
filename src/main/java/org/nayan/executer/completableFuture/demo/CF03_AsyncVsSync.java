package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Demonstrates synchronous (thenApply) vs asynchronous (thenApplyAsync) chaining.
 * - thenApply: continuing action runs in the same thread that completed the previous stage.
 * - thenApplyAsync: continuing action runs asynchronously (another thread, can pass an executor).
 * Reason to choose:
 *  - thenApply for cheap, CPU-light transforms
 *  - thenApplyAsync when transform is blocking/slow or you'd like parallelism
 */
public class CF03_AsyncVsSync {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Synchronous continuation: likely runs on the same thread that executed the supplier
        CompletableFuture<String> sync =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync (sync example): " + Thread.currentThread().getName());
                    return "Hello";
                }, executor).thenApply(val -> {
                    // thenApply likely executes on same thread - no new scheduling overhead
                    System.out.println("thenApply (sync): " + Thread.currentThread().getName());
                    return val + " Sync";
                });

        // Asynchronous continuation: scheduled separately, may run on another thread.
        CompletableFuture<String> async =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync (async example): " + Thread.currentThread().getName());
                    return "Hello";
                }, executor).thenApplyAsync(val -> {
                    // thenApplyAsync may run on a different thread from the executor
                    System.out.println("thenApplyAsync: " + Thread.currentThread().getName());
                    return val + " Async";
                }, executor);

        System.out.println(sync.join());
        System.out.println(async.join());

        executor.shutdown();
    }
}
