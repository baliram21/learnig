package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Demonstrates timeout helpers:
 * - orTimeout: makes CF fail with TimeoutException if not completed in time.
 * - completeOnTimeout: auto-completes with a default value if original doesn't finish in time.
 *
 * Useful to avoid waiting forever for slow dependencies.
 */
public class CF07_Timeouts {
    public static void main(String[] args) {
        // Task that sleeps longer than timeout
        CompletableFuture<String> f =
                CompletableFuture.supplyAsync(() -> {
                    sleep(5000);
                    return "Finished";
                });

        // orTimeout: if f doesn't finish within 2 seconds, it completes exceptionally with TimeoutException
        f.orTimeout(2, TimeUnit.SECONDS)
         .exceptionally(ex -> {
             // recover from timeout or other exceptions
             System.out.println("orTimeout triggered: " + ex.toString());
             return "Timed out fallback";
         }).thenAccept(System.out::println);

        // completeOnTimeout: will automatically complete with default if timeout occurs
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> {
                    sleep(5000);
                    return "Finished";
                }).completeOnTimeout("Default Value", 2, TimeUnit.SECONDS);

        System.out.println("f2 result = " + f2.join()); // Default Value (if timed out)

        // allow async tasks to finish for demo purposes
        sleep(3000);
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
