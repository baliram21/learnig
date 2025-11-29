package org.example.thread;

import java.util.concurrent.Semaphore;

public class SequenceWithSemaphores {
    private static final int THREADS = 3;
    private final Semaphore[] sems = new Semaphore[THREADS];
    private int counter = 1;
    private final int max;

    public SequenceWithSemaphores(int max) {
        this.max = max;
        for (int i = 0; i < THREADS; i++) sems[i] = new Semaphore(0);
        sems[0].release(); // allow thread-0 to start
    }

    class Printer implements Runnable {
        private final int id;
        Printer(int id) { this.id = id; }
        @Override
        public void run() {
            while (true) {
                try {
                    sems[id].acquire();
                } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }

                if (counter > max) {
                    // release next to allow termination if it's waiting
                    sems[(id + 1) % THREADS].release();
                    return;
                }

                System.out.println("Thread-" + id + ": " + counter);
                counter++;
                sems[(id + 1) % THREADS].release(); // hand over to next
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
        new SequenceWithSemaphores(30).startPrinting();
    }
}
