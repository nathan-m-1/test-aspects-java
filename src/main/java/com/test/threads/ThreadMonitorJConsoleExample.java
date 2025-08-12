package com.test.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ThreadMonitorJConsoleExample {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicio del programa - PID: " + ProcessHandle.current().pid());
        System.out.println("Abre JConsole o VisualVM y conéctate a este proceso.");

        // Pausa para que tengas tiempo de abrir la herramienta
        TimeUnit.SECONDS.sleep(15);

        Thread myThread = new Thread(() -> {
            long count = 0;
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start < 10000) { // 5 segundos corriendo sin pausa
                count++;
            }
            System.out.println("Conteo final: " + count);
        }, "ThreadEstadoRunnable");

        // Lanzamos varias tareas asíncronas
        CompletableFuture<?>[] futures = new CompletableFuture<?>[1];
        for (int i = 0; i < futures.length; i++) {
            int taskId = i;
            futures[i] = CompletableFuture.runAsync(() -> {
                System.out.println("Tarea " + taskId + " en hilo: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(30); // Simula trabajo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        CompletableFuture<Void> future = CompletableFuture.runAsync(myThread);

        // Pausa para que puedas ver los hilos activos en la herramienta
        System.out.println("Tareas lanzadas. Revisa los hilos en la herramienta ahora.");
        TimeUnit.SECONDS.sleep(10);

        // Esperamos que todas terminen
        CompletableFuture.allOf(futures).join();

        System.out.println("Todas las tareas terminaron. Observa cómo los hilos vuelven a estar inactivos.");

        // Mantener vivo el programa para observar liberación
        TimeUnit.SECONDS.sleep(20);
    }
}
