package com.test.completablefuture;

import java.util.concurrent.CompletableFuture;

public class GetNow {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Haciendo proceso en hilo principal");
        System.out.println("Mandando una tarea asincrona y verificando el resultado...");
        CompletableFuture<String> consultaLenta = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                return "Resultado desde servidor lento";
            } catch (InterruptedException e) {
                System.out.println(e);
                return "Resultado desde exception";
            }
        });

        String resultado = consultaLenta.getNow("Resultado desde cache local");
        System.out.println("Verificando, sino uso esto mientras tanto: " + resultado);
        System.out.println("Mientras sigo haciendo otras cosas");
        System.out.println("Vemos si ya esta el resultado: " 
        + consultaLenta.getNow("Aun sin respuesta"));
        Thread.sleep(6000);
        System.out.println("Y ahora: " 
        + consultaLenta.getNow("Aun sin respuesta"));

    }
}
