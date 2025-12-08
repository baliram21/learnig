package org.nayan.thread.prodconsproblem;

public class SharedResource {
    boolean isAvailable = false;

    public synchronized void addItem(){
        isAvailable = true;
        System.out.println("Item added by "+Thread.currentThread().getName()+" and invoking all thread which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("ConsumeItem method invoked by "+Thread.currentThread().getName());

        while (!isAvailable){
            try {
                System.out.println("Thread " +Thread.currentThread().getName() + " is waiting now");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Item Consumed by "+Thread.currentThread().getName());
        isAvailable=false;
    }
}
