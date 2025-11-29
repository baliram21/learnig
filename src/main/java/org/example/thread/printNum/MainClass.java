package org.example.thread.printNum;

public class MainClass {
    public static void main(String[] args) {
        final int threads = 3;
        final int limit = 20;

        NumberGenerator numberGenerator = new NumberGenerator(threads, limit);

        Thread t1 = new Thread(new TaskGenerator(numberGenerator, 1), "Thread-1");
        Thread t2 = new Thread(new TaskGenerator(numberGenerator, 2), "Thread-2");
        Thread t3 = new Thread(new TaskGenerator(numberGenerator, 0), "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        // join to wait for completion (optional)
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All done.");
    }
}
