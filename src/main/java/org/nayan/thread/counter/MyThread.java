package org.nayan.thread.counter;

public class MyThread implements Runnable {
   // AtomicInteger count = new AtomicInteger(0);
    int count=0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 1; i <= 1000; i++) {
            count=count+i;
           // count.incrementAndGet();
        }
    }

    public int getCount() {
        return count;
        //return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread th = new MyThread();

        Thread t1 = new Thread(th, "Thread-A");
        Thread t2 = new Thread(th, "Thread-B");

       // t1.start();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + th.getCount());
    }
}
