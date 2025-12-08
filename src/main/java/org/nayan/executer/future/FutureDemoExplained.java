package org.nayan.executer.future;

import java.util.concurrent.*;

public class FutureDemoExplained {
    public static void main(String[] args) 
            throws ExecutionException, InterruptedException, TimeoutException {

        // Creating a ThreadPoolExecutor with:
        // corePoolSize = 1, maxPoolSize = 1 → only 1 worker thread
        // keepAliveTime = 1 minute
        // workQueue = ArrayBlockingQueue of size 10
        // RejectionPolicy = AbortPolicy → throws RejectedExecutionException if queue is full
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(
                        1,
                        1,
                        1, TimeUnit.MINUTES,
                        new ArrayBlockingQueue<>(10),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy()
                );

        // Submitting a task using submit(): returns a Future object
        // The task sleeps for 7 seconds to simulate long-running work
        Future<?> futureObj = poolExecutor.submit(() -> {
            try {
                Thread.sleep(7000);  // Simulating long computation (7 seconds)
                System.out.println("This is Task which Thread will execute");
            } catch (InterruptedException e) {
                // Any interruption while sleeping will be wrapped into RuntimeException
                throw new RuntimeException(e);
            }
        });

        // Checking status immediately after submitting → always false
        // Because the task has just started and is still running
        System.out.println("is Done: " + futureObj.isDone());  // false

        // Trying to get result but with only 2 seconds timeout
        // Since the task takes 7 seconds, this call throws TimeoutException
        // IMPORTANT: The task continues running in background even after timeout.
        futureObj.get(2, TimeUnit.SECONDS);

        // This will only execute if timeout did not occur
        // In real execution this line never executes because above line throws exception
        futureObj.get();  // Waits indefinitely until task finishes

        // Now task is completed, so isDone() returns true
        System.out.println("is Done: " + futureObj.isDone());

        // Task was not canceled, so isCancelled() = false
        System.out.println("is Cancelled: " + futureObj.isCancelled());
    }
}
