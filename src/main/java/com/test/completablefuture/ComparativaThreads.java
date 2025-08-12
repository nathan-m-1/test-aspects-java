package com.test.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ComparativaThreads {

    public static void main(String[] args) {
        System.out.println("=== Usando new Thread() ===");
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("Hilo manual: " + Thread.currentThread().getName());
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }).start();
        }

        // Esperamos un poco antes de la segunda prueba
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        System.out.println("\n=== Usando runAsync() con ForkJoinPool por defecto ===");
        for (int i = 0; i < 5; i++) {
            CompletableFuture.runAsync(() -> {
                System.out.println("Hilo en pool: " + Thread.currentThread().getName());
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }).join();
        }
    }
}
