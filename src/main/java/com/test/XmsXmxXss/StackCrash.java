package com.test.XmsXmxXss;

// Llamada 5905 con stack por defatul, al parecer de 1m
// Llamada 1410 con stack pequeña 256k
// Llamada 23752 con stack grande Xss4m
// Ejemplo de salida: -XX:ThreadStackSize=4096
public class StackCrash {

    public static void main(String[] args) throws InterruptedException {
        try {
            recursiva(1);
        }catch (StackOverflowError e){
            System.out.println(e);
            System.out.println("Se acabo la memoria de stack");
            System.out.println("Esperando 40 segundos para ejecutar comando jinfo");
            Thread.sleep(1000*40);
            System.out.println("Programa terminado");
        }
    }

    public static void recursiva(int n) {
        System.out.println("Llamada " + n);
        recursiva(n + 1);
    }
}
