package org.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NumberPrinterLock {
    private int num = 1;
    private final int limit;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public NumberPrinterLock(int limit) {
        this.limit = limit;
    }

    public void printOdd() {
        while (true) {
            lock.lock();
            try {
                if (num > limit) return;

                while (num % 2 == 0) {
                    condition.await();
                }

                System.out.println("Odd  : " + num++);
                condition.signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printEven() {
        while (true) {
            lock.lock();
            try {
                if (num > limit) return;

                while (num % 2 != 0) {
                    condition.await();
                }

                System.out.println("Even : " + num++);
                condition.signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

public class EvenOddLockTest {
    public static void main(String[] args) {
        NumberPrinterLock printer = new NumberPrinterLock(10);

        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}
