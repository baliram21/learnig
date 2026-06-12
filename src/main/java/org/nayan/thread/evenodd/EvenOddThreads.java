package org.nayan.thread.evenodd;

class PrintNumbers {
    private int num = 1;
    private final int limit;

    public PrintNumbers(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (num <= limit) {
            while (num % 2 == 0) { // Wait if it's even
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (num <= limit) {
                System.out.println("Odd Thread: " + num);
                num++;
                notify(); // Notify even thread
            }
        }
    }

    public synchronized void printEven() {
        while (num <= limit) {
            while (num % 2 != 0) { // Wait if it's odd
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (num <= limit) {
                System.out.println("Even Thread: " + num);
                num++;
                notify(); // Notify odd thread
            }
        }
    }
}

public class EvenOddThreads {
    public static void main(String[] args) {
        int limit = 10; // Change limit as needed
        PrintNumbers printer = new PrintNumbers(limit);

        Thread t1 = new Thread(printer::printOdd, "OddThread");
        Thread t2 = new Thread(printer::printEven, "EvenThread");

        t1.start();
        t2.start();
    }
}
