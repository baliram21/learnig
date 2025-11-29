package org.example.thread;

public class SequenceWithWaitNotify {
    private static final int THREADS = 3;
    private final Object lock = new Object();
    private int counter = 1;
    private final int max;

    public SequenceWithWaitNotify(int max) { this.max = max; }

    class Printer implements Runnable {
        private final int id;
        Printer(int id) { this.id = id; }
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (counter <= max && (counter - 1) % THREADS != id) {
                        try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); return; }
                    }
                    if (counter > max) { lock.notifyAll(); return; }
                    System.out.println("Thread-" + id + ": " + counter);
                    counter++;
                    lock.notifyAll();
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
        new SequenceWithWaitNotify(30).startPrinting();
    }
}
