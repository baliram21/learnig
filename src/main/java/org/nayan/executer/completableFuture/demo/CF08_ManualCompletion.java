package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Shows manual control of CompletableFuture:
 * - new CompletableFuture<>() creates an incomplete future that you can complete manually.
 * - complete(value) sets a successful result.
 * - completeExceptionally(ex) sets failure.
 * Use when integrating non-Future APIs (callbacks) into CF world.
 */
public class CF08_ManualCompletion {
    public static void main(String[] args) {
        // Create an incomplete future
        CompletableFuture<String> f = new CompletableFuture<>();

        // In some callback/on-other-thread you can complete it:
        f.complete("Manual Value"); // anyone waiting on f will be unblocked

        System.out.println("f = " + f.join()); // prints Manual Value

        // Example of completing with an exception
        CompletableFuture<String> f2 = new CompletableFuture<>();
        f2.completeExceptionally(new RuntimeException("Manual Error"));

        // handle the exceptional completion gracefully
        f2.handle((val, ex) -> {
            if (ex != null) {
                System.out.println("f2 completed exceptionally: " + ex.getMessage());
                return "Recovered";
            }
            return val;
        }).join();
    }
}
