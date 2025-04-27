package com.test.shutdownhook;

public class CtrlCTest {

    public static void main(String[] args) {
        // User thread que sigue corriendo
        Thread userThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("User thread sigue corriendo...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("User thread interrumpido.");
            }
        });

        userThread.start();

        // Shutdown Hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
//                try {
                    System.out.println("Shutdown Hook ejecutándose...");
                    //Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    System.out.println("ShutdownHook thread interrumpido.");
//                }
            }
        }));

        System.out.println("Presiona Ctrl+C para salir.");
    }
}
