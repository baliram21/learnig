package org.nayan.thread.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger count = new AtomicInteger(0);
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
        };

        // submit two tasks to the pool
        pool.submit(task);
        pool.submit(task);

        // orderly shutdown and wait
        pool.shutdown();
        boolean finished = pool.awaitTermination(5, TimeUnit.SECONDS);
        if (!finished) {
            System.err.println("Pool didn't terminate in time, forcing shutdown.");
            pool.shutdownNow();
        }

        System.out.println("Final Count :- " + count.get()); // Always 2000
    }
}
