package org.nayan.thread.printNum;

public class PrintNumbersThreeThreads {

    private int number = 1;
    private final int MAX = 20;
    private int turn = 0; // 0 -> T1, 1 -> T2, 2 -> T3

    public synchronized void print(int threadId) {
        while (number <= MAX) {
            while (turn != threadId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (number <= MAX) {
                System.out.println(Thread.currentThread().getName() + " -> " + number++);
                turn = (turn + 1) % 3;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintNumbersThreeThreads obj = new PrintNumbersThreeThreads();

        Thread t1 = new Thread(() -> obj.print(0), "Thread-1");
        Thread t2 = new Thread(() -> obj.print(1), "Thread-2");
        Thread t3 = new Thread(() -> obj.print(2), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
