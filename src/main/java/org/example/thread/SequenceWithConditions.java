package org.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SequenceWithConditions {
    private static final int THREADS = 3;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition[] conds = new Condition[THREADS];
    private int counter = 1;
    private final int max;

    public SequenceWithConditions(int max) {
        this.max = max;
        for (int i = 0; i < THREADS; i++) conds[i] = lock.newCondition();
    }

    class Printer implements Runnable {
        private final int id;

        Printer(int id) { this.id = id; }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (counter <= max && (counter - 1) % THREADS != id) {
                        conds[id].await();
                    }

                    if (counter > max) { // done -> wake next in case it's waiting, then exit
                        conds[(id + 1) % THREADS].signal();
                        break;
                    }

                    System.out.println("Thread-" + id + ": " + counter);
                    counter++;
                    conds[(id + 1) % THREADS].signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public void startPrinting() throws InterruptedException {
        Thread[] ts = new Thread[THREADS];
        for (int i = 0; i < THREADS; i++) {
            ts[i] = new Thread(new Printer(i), "T-" + i);
            ts[i].start();
        }
        for (Thread t : ts) t.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new SequenceWithConditions(30).startPrinting();
    }
}
