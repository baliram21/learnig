package other.baliram.thread.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<List<Integer>> future = service.submit(() -> {
            System.out.println("Thread :- "+Thread.currentThread().getName());
            Thread.sleep(10000);
            return Arrays.asList(1, 2, 3, 4, 5);
        });

        List<Integer> list = future.get();
        System.out.println(list);

        service.shutdown();


    }
}
