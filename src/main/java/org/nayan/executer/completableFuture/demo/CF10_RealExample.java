package org.nayan.executer.completableFuture.demo;

import java.util.concurrent.*;

/**
 * A compact real-world-looking example: supplyAsync + thenApply on same executor.
 * Demonstrates how thread names look when using custom ThreadPoolExecutor and synchronous chaining.
 */
public class CF10_RealExample {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 1, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory());

        // supplyAsync runs in executor thread
        CompletableFuture<String> task =
                CompletableFuture.supplyAsync(() ->
                        "Hello from " + Thread.currentThread().getName(), executor)
                        // thenApply (not thenApplyAsync) will run synchronously on the same thread
                        .thenApply(val ->
                                val + " processed by " + Thread.currentThread().getName());

        // get blocks until complete and returns computed string
        System.out.println(task.get()); // you will see the same thread name printed twice

        executor.shutdown();
    }
}
