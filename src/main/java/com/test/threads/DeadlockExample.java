package com.test.threads;

public class DeadlockExample {

    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void metodo1() {
        synchronized (lockA) {
            System.out.println("metodo1: bloqueó lockA");
            sleep(100);
            synchronized (lockB) {
                System.out.println("metodo1: bloqueó lockB");
            }
        }
    }

    public void metodo2() {
        synchronized (lockB) {
            System.out.println("metodo2: bloqueó lockB");
            sleep(100);
            synchronized (lockA) {
                System.out.println("metodo2: bloqueó lockA");
            }
        }
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        Thread t1 = new Thread(example::metodo1, "Hilo-1");
        Thread t2 = new Thread(example::metodo2, "Hilo-2");

        t1.start();
        t2.start();
    }
}
