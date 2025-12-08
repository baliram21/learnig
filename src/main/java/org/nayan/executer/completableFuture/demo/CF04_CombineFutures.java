package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Demonstrates combining futures:
 * - thenCombine: when both independent results are available, combine them into a new value.
 * - thenCompose: flatMap-like: when second async depends on the first's result (avoids nested CFs).
 */
public class CF04_CombineFutures {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(() -> "Hello", executor);

        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> "Nayan", executor);

        // thenCombine: combine results of f1 and f2 when both complete.
        CompletableFuture<String> combined =
                f1.thenCombine(f2, (a, b) -> a + " " + b);

        // thenCompose: use f1's result to start another async computation and return its result directly.
        CompletableFuture<String> composed =
                f1.thenCompose(val ->
                        CompletableFuture.supplyAsync(() -> val + " Kumar", executor));

        System.out.println("combined = " + combined.join()); // Hello Nayan
        System.out.println("composed = " + composed.join()); // Hello Kumar

        executor.shutdown();
    }
}
