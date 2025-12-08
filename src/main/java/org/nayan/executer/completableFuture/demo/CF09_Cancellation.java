package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Demonstrates cancellation:
 * - cancel(true): attempts to cancel; if underlying task is interruptible, it may stop early.
 * - isCancelled() tells if CF was cancelled.
 * - Cancellation propagates as CancellationException to callers (join/get).
 */
public class CF09_Cancellation {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> f =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        for (int i = 0; i < 5; i++) {
                            Thread.sleep(1000);
                            System.out.println("working " + i);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("task interrupted");
                        // If interrupted we can stop work and optionally rethrow
                        return "Interrupted Result";
                    }
                    return "Finished";
                });

        // Let the task run a bit
        Thread.sleep(1500);

        // Request cancellation — best-effort. Underlying thread gets interrupted if running.
        boolean cancelled = f.cancel(true);
        System.out.println("cancel requested = " + cancelled);
        System.out.println("isCancelled = " + f.isCancelled());

        // If you call join/get after cancellation, a CancellationException is thrown.
        try {
            System.out.println(f.join());
        } catch (CancellationException ex) {
            System.out.println("join failed due to cancellation: " + ex);
        }
    }
}
