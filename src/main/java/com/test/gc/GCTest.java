package com.test.gc;

public class GCTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando prueba de GC con: " + System.getProperty("java.vm.name"));

        for (int i = 0; i < 10; i++) {
            // Crear carga artificial: muchos objetos temporales
            for (int j = 0; j < 1_000_000; j++) {
                String data = new String(new char[1000]); // ~1 KB por objeto
                data.intern(); // Forzar intern para evitar optimización
            }

            // Esperar un poco entre cargas
            System.out.println("Iteración " + i + " completa.");
            Thread.sleep(1000); // 1 segundo
        }

        System.out.println("Finalizando prueba.");
    }
}
