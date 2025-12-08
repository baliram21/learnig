package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * Shows exception handling patterns:
 * - exceptionally: recover and return fallback value when exception occurs.
 * - handle: receives both result and exception; can return a result or fallback.
 * - whenComplete: callback invoked on completion; does not change the result.
 *
 * Use these to make CF-based pipelines resilient.
 */
public class CF06_ErrorHandling {
    public static void main(String[] args) {
        // a future that throws
        CompletableFuture<String> f =
                CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException("Boom!");
                });

        // exceptionally: only called when exception occurs; returns fallback value.
        CompletableFuture<String> recovered =
                f.exceptionally(ex -> {
                    System.out.println("exceptionally handler: " + ex.getMessage());
                    return "Default Value";
                });

        // handle: receives (value, exception) and must return some result.
        CompletableFuture<String> handled =
                f.handle((val, ex) -> {
                    if (ex != null) {
                        System.out.println("handle saw exception: " + ex.getMessage());
                        return "Handled Error";
                    }
                    return val;
                });

        // whenComplete: runs side-effect on completion; doesn't change the value.
        CompletableFuture<String> whenComplete =
                f.whenComplete((val, ex) -> {
                    if (ex != null) System.out.println("whenComplete saw: " + ex.getMessage());
                    else System.out.println("whenComplete val: " + val);
                }).exceptionally(ex -> "ignored");

        System.out.println("recovered = " + recovered.join());
        System.out.println("handled = " + handled.join());
        System.out.println("whenComplete result = " + whenComplete.join());
    }
}
