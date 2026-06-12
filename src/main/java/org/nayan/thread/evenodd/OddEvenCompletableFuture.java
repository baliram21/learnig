package org.nayan.thread.evenodd;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenCompletableFuture {
    public static void main(String[] args) {
        final int MAX = 20;

        // Thread pool (doesn't matter how many threads)
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Start chain
        CompletableFuture<Void> chain = CompletableFuture.completedFuture(null);

        for (int i = 1; i <= MAX; i++) {
            final int num = i;

            chain = chain.thenRunAsync(() -> {
                if (num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() +
                            " -> EVEN : " + num);
                } else {
                    System.out.println(Thread.currentThread().getName() +
                            " -> ODD  : " + num);
                }
            }, executor);
        }

        chain.join();        // wait for all tasks
        executor.shutdown(); // shutdown executor
    }
}
