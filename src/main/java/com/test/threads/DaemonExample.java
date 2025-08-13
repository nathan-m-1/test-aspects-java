package com.test.threads;

public class DaemonExample {

    public static void main(String[] args) {
        System.out.println("Main thread inicia");

        Thread daemon = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println("Daemon trabajando... " + i++);
                try {
                    Thread.sleep(500); // simula trabajo
                } catch (InterruptedException e) {
                    System.out.println("Daemon interrumpido");
                    break;
                }
            }
        });

        daemon.setDaemon(true); // <- lo marcamos como daemon
        daemon.start();

        try {
            Thread.sleep(2000); // main trabaja un poco
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread termina");
    }
}
