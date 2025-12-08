package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Demonstrates running multiple independent tasks in parallel and waiting for all to finish using allOf.
 * - allOf returns CompletableFuture<Void> that completes when all provided CFs complete.
 * - You typically then collect results by calling join/get on each future.
 */
public class CF05_ParallelExecution {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> {
            sleep(500);
            return "A";
        }, executor);

        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> {
            sleep(300);
            return "B";
        }, executor);

        CompletableFuture<String> c = CompletableFuture.supplyAsync(() -> {
            sleep(100);
            return "C";
        }, executor);

        // allOf waits until a, b, c finish; returns CF<Void>
        CompletableFuture<Void> all = CompletableFuture.allOf(a, b, c);
        all.join(); // block until all done

        // collect results from original futures (safe after all.join())
        System.out.println(a.join() + b.join() + c.join()); // ABC

        executor.shutdown();
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
