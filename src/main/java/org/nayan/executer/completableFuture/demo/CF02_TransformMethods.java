package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Shows common transform/consume/then methods:
 *  - thenApply (sync transform): transforms the result, runs in same thread that completed previous stage.
 *  - thenApplyAsync (async transform): runs transform in another thread or provided executor.
 *  - thenAccept: consumes value and returns CompletableFuture<Void>.
 *  - thenRun: runs after completion but receives no result.
 */
public class CF02_TransformMethods {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // thenApply: transforms the result. This runs in the same thread that completed the previous stage
        // (unless you use thenApplyAsync). Good for cheap, non-blocking transformations.
        CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(() -> "Hello", executor)
                        .thenApply(val -> {
                            // runs in same completing thread by default
                            return val + " Nayan";
                        });

        // thenAccept: consume the value (side-effect) and return a CF<Void>.
        CompletableFuture<Void> f2 =
                CompletableFuture.supplyAsync(() -> "Hi", executor)
                        .thenAccept(val -> System.out.println("Received: " + val));

        // thenRun: runs after previous stage completes but doesn't get its result.
        CompletableFuture<Void> f3 =
                CompletableFuture.supplyAsync(() -> 10, executor)
                        .thenRun(() -> System.out.println("Task finished (no result param)"));

        System.out.println(f1.join());
        f2.join();
        f3.join();

        executor.shutdown();
    }
}
