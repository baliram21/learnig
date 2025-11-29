package org.example.thread;

class NumberPrinter {
    private int num = 1;
    private final int limit;

    public NumberPrinter(int limit) {
        this.limit = limit;
    }

    public synchronized void printOdd() {
        while (num <= limit) {
            if (num % 2 == 0) {      // Not odd → wait
                try { wait(); } catch (InterruptedException e) {}
            } else {
                System.out.println("Odd  : " + num);
                num++;
                notifyAll();         // Wake up even thread
            }
        }
    }

    public synchronized void printEven() {
        while (num <= limit) {
            if (num % 2 != 0) {      // Not even → wait
                try { wait(); } catch (InterruptedException e) {}
            } else {
                System.out.println("Even : " + num);
                num++;
                notifyAll();         // Wake up odd thread
            }
        }
    }
}

public class EvenOddThread {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter(10);

        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }
}
