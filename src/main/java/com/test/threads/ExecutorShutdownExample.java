package com.test.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdownExample {

    public static void main(String[] args) throws InterruptedException {
        // Creamos un Executor con 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        TimeUnit.SECONDS.sleep(15);

        // Lanzamos 5 tareas
        for (int i = 0; i < 5; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Tarea " + id + " ejecutándose en " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2); // simula trabajo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Iniciamos el cierre: no acepta nuevas tareas pero ejecuta las pendientes
        // Si no llamamos el shutdown los hilos siguen vivos aunque el programa haya terminado
        executor.shutdown();

        // Esperamos hasta 5 segundos para que terminen todas las tareas
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("No terminaron todas las tareas, se fuerza cierre");
            executor.shutdownNow(); // Forzamos cierre inmediato
        } else {
            System.out.println("Todas las tareas terminaron, hilos liberados");
        }

        // Opcional: verificar si el executor está terminado
        System.out.println("Executor terminado: " + executor.isTerminated());
    }
}
