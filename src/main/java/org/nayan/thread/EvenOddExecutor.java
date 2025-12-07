package org.nayan.thread;

import java.util.concurrent.*;

public class EvenOddExecutor {
    private static final int LIMIT = 10;
    private static final BlockingQueue<Integer> oddQueue = new ArrayBlockingQueue<>(1);
    private static final BlockingQueue<Integer> evenQueue = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);

        oddQueue.put(1);  // Start with odd

        service.submit(() -> {
            for (int i = 1; i <= LIMIT; i += 2) {
                int val = 0;
                try {
                    val = oddQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Odd  : " + val);
                if (val + 1 <= LIMIT) {
                    try {
                        evenQueue.put(val + 1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        service.submit(() -> {
            for (int i = 2; i <= LIMIT; i += 2) {
                int val = 0;
                try {
                    val = evenQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Even : " + val);
                if (val + 1 <= LIMIT) {
                    try {
                        oddQueue.put(val + 1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        service.shutdown();
    }
}
