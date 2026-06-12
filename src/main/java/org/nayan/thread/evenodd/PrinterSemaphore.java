package org.nayan.thread.evenodd;

import java.util.concurrent.Semaphore;

public class PrinterSemaphore {

    private int num = 1;
    private final int limit;

    private final Semaphore odd = new Semaphore(1);
    private final Semaphore even = new Semaphore(0);

    public PrinterSemaphore(int limit) {
        this.limit = limit;
    }

    public void printOdd() {
        while (num <= limit) {
            try {
                odd.acquire();
                if (num <= limit) {
                    System.out.println("Odd : " + num++);
                }
                even.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void printEven() {
        while (num <= limit) {
            try {
                even.acquire();
                if (num <= limit) {
                    System.out.println("Even : " + num++);
                }
                odd.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}