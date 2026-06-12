package org.nayan.thread.evenodd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterLock {

    private int num = 1;
    private final int limit;

    private final Lock lock = new ReentrantLock(true); // fair lock
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();

    public PrinterLock(int limit) {
        this.limit = limit;
    }

    public void printOdd() {
        lock.lock();
        try {
            while (num <= limit) {
                while (num % 2 == 0) {
                    oddCondition.await();
                }
                if (num <= limit) {
                    System.out.println("Odd : " + num++);
                    evenCondition.signal();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        lock.lock();
        try {
            while (num <= limit) {
                while (num % 2 != 0) {
                    evenCondition.await();
                }
                if (num <= limit) {
                    System.out.println("Even : " + num++);
                    oddCondition.signal();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}