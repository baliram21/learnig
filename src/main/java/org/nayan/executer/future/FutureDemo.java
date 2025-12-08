package org.nayan.executer.future;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(1, 1, 1,
                        TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),
                        Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        /*Future<?> futureObj = poolExecutor.submit(() -> {
            System.out.println("This is Task which Thread will execute");*/
        Future<?> futureObj = poolExecutor.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("This is Task which Thread will execute");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        System.out.println("is Done "+futureObj.isDone());

        futureObj.get(2,TimeUnit.SECONDS);
        futureObj.get();
        System.out.println("is Done "+futureObj.isDone());
        System.out.println("is Cancelled "+futureObj.isCancelled());
    }
}
