package org.nayan.executer.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemo2Explained {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException, TimeoutException {

        // Creating a ThreadPoolExecutor with 3 threads
        // Both corePoolSize and maxPoolSize = 3 → fixed thread pool of 3 threads
        // keepAliveTime = 3 minutes
        // workQueue = ArrayBlockingQueue(10)
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(
                        3, 3,
                        3, TimeUnit.MINUTES,
                        new ArrayBlockingQueue<>(10),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy()
                );


        /* ---------------------------------------------------------
           1. SUBMITTING A RUNNABLE WITHOUT A RESULT
           --------------------------------------------------------- */

        Future<?> futureObj1 = poolExecutor.submit(() -> {
            // Runnable has NO return value
            System.out.println("Task1 with Runnable");
        });

        // For Runnable, Future.get() always returns NULL
        Object obj = futureObj1.get(); // Wait until task completes
        System.out.println(obj == null);  // true


        /* ---------------------------------------------------------
           2. SUBMITTING A RUNNABLE WITH A RETURN OBJECT
           ---------------------------------------------------------
           submit(Runnable task, T result)
           - Runnable does NOT produce a result
           - But we can PASS a result object that will be returned by Future.get()
         --------------------------------------------------------- */

        List<Integer> list = new ArrayList<>();

        Future<List<Integer>> futureObj2 = poolExecutor.submit(() -> {
            list.add(100);
            System.out.println("Task2 with Runnable and Return object");
        }, list); // <-- This list will be returned when Future.get() is called

        // Future.get() returns the passed "list"
        List<Integer> listFromFutureObj2 = futureObj2.get();
        System.out.println(listFromFutureObj2.get(0)); // prints 100


        /* ---------------------------------------------------------
           3. SUBMITTING A CALLABLE THAT RETURNS A VALUE
           ---------------------------------------------------------
           Callable<T> returns a value using RETURN statement.
           submit(Callable<T>) returns Future<T>
         --------------------------------------------------------- */

        Future<List<Integer>> futureObj3 = poolExecutor.submit(() -> {
            System.out.println("Task3 with Callable");
            List<Integer> listObj = new ArrayList<>();
            listObj.add(200);
            return listObj;   // Callable MUST return something
        });

        // IMPORTANT:
        // You accidentally wrote futureObj2.get() again in your original code.
        // That is a BUG. It should be futureObj3.get().
        List<Integer> listFromFutureObj3 = futureObj3.get(); // FIXED
        System.out.println(listFromFutureObj3.get(0)); // prints 200
    }
}
