package com.test.threads.virtualthreads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class NormalThreadTest {

    public static void main(String[] args) {
        int tasks = 10_000;

        long inicio = System.nanoTime();

        try (var pool = Executors.newFixedThreadPool(200)) {
            IntStream.range(0, tasks)
                    .forEach(i -> pool.submit(() -> {
                        try {
                            Thread.sleep(Duration.ofMillis(100));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }));
        }

        long fin = System.nanoTime();

        double duracionMs = (fin - inicio) / 1_000_000.0;
        System.out.printf("Tiempo: %.2f ms%n", duracionMs);

        double segundos = (fin - inicio) / 1_000_000_000.0;
        System.out.printf("Tiempo: %.2f segundos%n", segundos);
    }

}
