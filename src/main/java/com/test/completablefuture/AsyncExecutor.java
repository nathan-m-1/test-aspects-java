package com.test.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Tarea con executor propio: " + Thread.currentThread().getName());
                System.out.println("Entrando a tarea en segundo plano: " + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("Termina tarea en segundo plano: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executor);

        future.join();
        executor.shutdown();
    }
}
