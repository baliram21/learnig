package org.example.thread.counter;

public class ThreadCounter implements Runnable{

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadCounter counter = new ThreadCounter();

        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);

        t1.start();
        t2.start();



        System.out.println("Total count value :- "+counter.count); // this will always give 0 as output

        System.out.println("Total count value :- "+counter.getCount());
    }
}
