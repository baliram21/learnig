package org.nayan.thread.racecondition;

public class MonitorLockExample {
    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();
        Thread t1 = new Thread(()-> obj.task1());
        Thread t2 = new Thread(()-> obj.task2());
        Thread t3 = new Thread(()-> obj.task3());

        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void task1(){
        try {
            System.out.println("Inside task1() method");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void task2(){
        System.out.println("task2(), before synchronized ");
        synchronized (this){
            System.out.println("task2() Inside synchronized");
        }
    }

    public void task3(){
        System.out.println("Inside task3() ");
    }
}
