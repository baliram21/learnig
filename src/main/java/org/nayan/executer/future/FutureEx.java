package org.nayan.executer.future;

import java.util.List;
import java.util.concurrent.*;

public class FutureEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<List<Integer>> listFuture = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            return List.of(1, 2, 3, 4, 5, 6);
        });
        System.out.println(listFuture.isDone() + " " + Thread.currentThread().getName());
        System.out.println(listFuture.isCancelled()+ " " + Thread.currentThread().getName());
        System.out.println(listFuture.get()+ " " + Thread.currentThread().getName());
        System.out.println(listFuture.isDone()+ " " + Thread.currentThread().getName());
        System.out.println("________________________________________________________");

        ExecutorService executorService2 = Executors.newFixedThreadPool(1);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return List.of(1, 2, 3, 4, 5, 6);
        }, executorService2).thenAccept(System.out::println);

      //  System.out.println(voidCompletableFuture.get());

        executorService.shutdown();
        executorService2.shutdown();
    }
}
