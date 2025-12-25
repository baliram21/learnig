package other.baliram.thread.completableFuture;

import java.util.concurrent.CompletableFuture;

public class FutureMethodsDemo {
    public static void main(String[] args) {

        CompletableFuture<String> str1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> str2 = CompletableFuture.supplyAsync(() -> " nayan");

        CompletableFuture<Void> allOf = CompletableFuture.allOf(str1, str2);

        allOf.thenRun(() -> {
            System.out.print(str1.join());
            System.out.println(str2.join());
        }).join();

        System.out.println(allOf.join());

        CompletableFuture<String> thenCombineStr = str1.thenCombine(str2, (a, b) -> a + " " + b);
        System.out.println(thenCombineStr.join());

        CompletableFuture<String> stringCompletableFuture = str1
                .thenCompose(str -> CompletableFuture.supplyAsync(() -> str +" Nayan Kumar"));

        System.out.println(stringCompletableFuture.join());
    }
}