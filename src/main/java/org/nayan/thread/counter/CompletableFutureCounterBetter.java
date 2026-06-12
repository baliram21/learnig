package org.nayan.thread.counter;

import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class CompletableFutureCounterBetter {

    public static void main(String[] args) {

        LongAdder counter = new LongAdder();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture[] futures = IntStream.range(0, 2000)
                .mapToObj(i ->
                        CompletableFuture.runAsync(counter::increment, executor)
                )
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        System.out.println("Final Counter Value: " + counter.sum());

        executor.shutdown();
    }
}