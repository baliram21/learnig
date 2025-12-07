package org.nayan.thread.wait_notify;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        ExecutorService exec = Executors.newFixedThreadPool(2);

        // producer
        exec.submit(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i);
                    System.out.printf("Produced %d (size=%d)%n", i, queue.size());
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // consumer
        exec.submit(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Integer x = queue.take();
                    System.out.printf("Consumed %d (size=%d)%n", x, queue.size());
                    Thread.sleep(80);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        exec.shutdown();
        // wait for termination or use awaitTermination in production
    }
}
