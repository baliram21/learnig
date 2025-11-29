package org.example.thread;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicNumberPrinter {
    private AtomicInteger num = new AtomicInteger(1);
    private final int limit;

    public AtomicNumberPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (num.get() <= limit) {
            if (num.get() % 2 == 0) {
                try { wait(); } catch (InterruptedException e) {}
            } else {
                System.out.println("Odd  : " + num.getAndIncrement());
                notifyAll();
            }
        }
    }

    public synchronized void printEven() {
        while (num.get() <= limit) {
            if (num.get() % 2 != 0) {
                try { wait(); } catch (InterruptedException e) {}
            } else {
                System.out.println("Even : " + num.getAndIncrement());
                notifyAll();
            }
        }
    }
}

public class AtomicEvenOdd {
    public static void main(String[] args) {
        AtomicNumberPrinter printer = new AtomicNumberPrinter(10);

        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}
