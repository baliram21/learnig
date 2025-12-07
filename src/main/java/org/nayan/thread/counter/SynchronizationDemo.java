package org.nayan.thread.counter;

public class SynchronizationDemo {

    private int count = 0;

    public synchronized void counter(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizationDemo demo = new SynchronizationDemo();

      Thread t1 = new Thread(()-> {
            for (int i = 1; i <= 1000; i++) {
                demo.counter();
            }
        });

        Thread t2 = new Thread(()-> {
            for (int i = 1; i <= 1000; i++) {
                demo.counter();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count :- "+demo.count);
    }
}
