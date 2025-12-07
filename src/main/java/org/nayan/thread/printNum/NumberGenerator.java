package org.nayan.thread.printNum;

public class NumberGenerator {
    private int num = 1;
    private final int noOfThreads;
    private final int limit;

    public NumberGenerator(int noOfThreads, int limit) {
        this.noOfThreads = noOfThreads;
        this.limit = limit;
    }

    /**
     * Each thread calls printNum(result) where `result` is the thread's expected remainder.
     * This method runs until num > limit.
     */
    public void printNum(int result) throws InterruptedException {
        synchronized (this) {
            // Keep trying until we've printed up to limit
            while (num <= limit) {
                // Wait until it's this thread's turn (or until we've passed the limit)
                while (num <= limit && num % noOfThreads != result) {
                    wait();
                }

                // If another thread finished us off while we were waiting, exit
                if (num > limit) {
                    // Wake others so they can also exit if waiting
                    notifyAll();
                    break;
                }

                // It's this thread's turn — print and advance
                System.out.println(Thread.currentThread().getName() + " " + num);
                num++;

                // Wake up other threads to let next one run
                notifyAll();
            }
        }
    }
}
