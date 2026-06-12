package org.nayan.thread.producerconsumer.a;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread start...");

        SharedResource sharedResource = new SharedResource();

        Thread producer = new Thread(new ProduceTask(sharedResource));
        Thread consumer = new Thread(new ConsumeTask(sharedResource));

        producer.start();
        consumer.start();
    }
}
