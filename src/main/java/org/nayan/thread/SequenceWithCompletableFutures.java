package org.nayan.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SequenceWithCompletableFutures {
    public static void main(String[] args) {
        final int MAX = 30;
        final int THREADS = 3;

        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        // Start with a completed future so we can chain the first task.
        CompletableFuture<Void> chain = CompletableFuture.completedFuture(null);

        for (int i = 1; i <= MAX; i++) {
            final int num = i; // capture loop variable
            chain = chain.thenRunAsync(() -> {
                // This runs on one of the executor's threads, but ordering is preserved by chaining
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " -> " + num);
                // Simulate work (optional)
                // try { Thread.sleep(10); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }, executor);
        }

        // Wait for the whole chain to finish
        chain.join();

        // Shutdown executor
        executor.shutdown();
        System.out.println("Done.");
    }
}
