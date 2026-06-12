package org.nayan.executer.future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureEx2 {
    public static void main(String[] args) {

        CompletableFuture
                .supplyAsync(() -> 10)
                .thenApply(x -> x * 2)
                .thenApply(x -> x + 5)
                .thenAccept(System.out::println);

        CompletableFuture
                .supplyAsync(() -> 10 / 0)
                .exceptionally(ex -> {
                    System.out.println("Error: " + ex);
                    return 0;
                });
        /*Future<User> user = executor.submit(() -> getUser());
        Future<Order> order = executor.submit(() -> getOrder());

        User u = user.get();     // blocks
        Order o = order.get();  // blocks*/

        /*CompletableFuture<User> user =
                CompletableFuture.supplyAsync(() -> getUser());

        CompletableFuture<Order> order =
                CompletableFuture.supplyAsync(() -> getOrder());

        CompletableFuture<AggregateResponse> result =
                user.thenCombine(order, (u, o) -> new AggregateResponse(u, o));*/

/*
        CompletableFuture
                .supplyAsync(() -> callThirdParty())
                .orTimeout(2, TimeUnit.SECONDS)
                .exceptionally(ex -> "DEFAULT_RESPONSE");
*/




    }
}
