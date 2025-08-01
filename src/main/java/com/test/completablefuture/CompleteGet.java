package com.test.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteGet {

    public static void main(String[] args) {
        
        CompletableFuture<String> future = new CompletableFuture<>();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                future.complete("Listo desde el hilo");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        }).start();

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } 
    }
}
