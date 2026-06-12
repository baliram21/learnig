package org.nayan.thread.counter;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CompletableFutureCounter {

    public static void main(String[] args) {

        AtomicInteger counter = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Launch 100 async tasks
        CompletableFuture[] futures = IntStream.range(0, 100)
                .mapToObj(i ->
                        CompletableFuture.runAsync(counter::incrementAndGet, executor)
                )
                .toArray(CompletableFuture[]::new);

        // Wait for all tasks to complete
        CompletableFuture.allOf(futures).join();

        System.out.println("Final Counter Value: " + counter.get());

        executor.shutdown();
    }
}