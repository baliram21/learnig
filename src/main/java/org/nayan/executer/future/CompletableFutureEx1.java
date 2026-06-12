package org.nayan.executer.future;

import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureEx1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService3 = Executors.newFixedThreadPool(1);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return List.of(1, 2, 3, 4, 5, 6);
        }, executorService3)
                .thenAccept(System.out::println)
                .orTimeout(1000, TimeUnit.MILLISECONDS);

        //  System.out.println(voidCompletableFuture.get());


        executorService3.shutdown();
    }

}
