package com.test.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Async {

    public static void main(String[] args) {

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Entrando a tarea en segundo plano: " + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("Termina tarea en segundo plano: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Hilo principal sigue trabajando...");

        // Esperar a que termine (para ver el mensaje antes de que el programa acabe)
        future.join();
    }
}
