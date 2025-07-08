package com.test.XmsXmxXss;

public class VerHeapInicial {

    public static void main(String[] args) {
        long heapMax = Runtime.getRuntime().maxMemory();
        long heapInit = Runtime.getRuntime().totalMemory();
        System.out.println("Heap inicial (totalMemory): " + heapInit / (1024 * 1024) + " MB");
        System.out.println("Heap máximo (maxMemory): " + heapMax / (1024 * 1024) + " MB");
        for (int i = 0; i < 40; i++) {
            try {
                System.out.println("Programa corriendo: " + i);
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
