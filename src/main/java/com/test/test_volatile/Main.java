package com.test.test_volatile;

class Worker extends Thread {
    private volatile boolean running = true; // Sin volatile

    public void run() {
        while (running) {
            // Haciendo algo...
//            try {
//                Thread.sleep(2000);
//                System.out.println("Hilo coriendo...");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
        System.out.println("Hilo detenido.");
    }

    public void stopRunning() {
        running = false;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();

        Thread.sleep(1000);
        worker.stopRunning(); // Puede que el otro hilo nunca vea este cambio
    }
}

