package org.nayan.executer.completableFuture;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor =
                    new ThreadPoolExecutor(1, 1, 1,
                            TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),
                            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                return "Task Completed ";
            }, poolExecutor);

            System.out.println(asyncTask1.get());

            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
                return "Hello ";
            }, poolExecutor).thenApply((String val)->{
                return val+ "Nayan Kumar";
            });

            System.out.println(asyncTask2.get());

            CompletableFuture<String> asyncTask3 = CompletableFuture.supplyAsync(() -> {
                return "Hello " +Thread.currentThread().getName();
            }, poolExecutor)
                    .thenApply((String val)->{
                return val+ "Nayan Kumar "+Thread.currentThread().getName();
            });

            System.out.println(asyncTask3.get());

        }catch (Exception e){

        }
    }
}
