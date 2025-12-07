package org.nayan.thread.deadlock;

public class DeadlockDemo {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void task1() {
        synchronized (lock1) {
            System.out.println("Task1 acquired lock1");

            // Sleep ensures task2 gets a chance to lock lock2
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            System.out.println("Task1 trying to acquire lock2");
            synchronized (lock2) {
                System.out.println("Task1 acquired lock2");
            }
        }
    }

    public void task2() {
        synchronized (lock2) {
            System.out.println("Task2 acquired lock2");

            // Sleep ensures task1 gets a chance to lock lock1
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            System.out.println("Task2 trying to acquire lock1");
            synchronized (lock1) {
                System.out.println("Task2 acquired lock1");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockDemo demo = new DeadlockDemo();

        Thread t1 = new Thread(demo::task1, "Thread-1");
        Thread t2 = new Thread(demo::task2, "Thread-2");

        t1.start();
        t2.start();
    }
}
