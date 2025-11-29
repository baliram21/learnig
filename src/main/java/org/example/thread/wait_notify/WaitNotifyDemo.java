package org.example.thread.wait_notify;

public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock){
                System.out.println("enter into Thread-1 block- Waiting...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread-1 : Resumed. ");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock){
                System.out.println("enter into Thread-2 block- Notifying ....");
                lock.notify();
                System.out.println("Thread-2 Notified. ");
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
