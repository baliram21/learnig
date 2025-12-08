package org.nayan.executer.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(3, 3, 3,
                        TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj1 = poolExecutor.submit(() -> {
            System.out.println("Task1 with Runnable ");
        });

        Object obj = futureObj1.get();
        System.out.println(obj == null);

        List<Integer> list = new ArrayList<>();
        Future<List<Integer>> futureObj2 = poolExecutor.submit(() -> {
            list.add(100);
            System.out.println("Task2 with Runnable and Return object");
        }, list);

        List<Integer> listFromFutureObj2 = futureObj2.get();
        System.out.println(listFromFutureObj2.get(0));

        Future<List<Integer>> futureObj3 = poolExecutor.submit(() -> {
            System.out.println("Task3 with Callable");
            List<Integer> listObj = new ArrayList<>();
            listObj.add(200);
            return listObj;
        });
        List<Integer> listFromFutureObj3 = futureObj2.get();
        System.out.println(listFromFutureObj3.get(0));

    }
}
