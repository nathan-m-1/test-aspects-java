package com.test.XmsXmxXss;

import java.util.ArrayList;
import java.util.List;

// Objetos: 985 con heap por default. -XX:InitialHeapSize=260046848 -> 248 MB; -XX:MaxHeapSize=4135583744 -> 3.85 GB
// Objetos: 15 con heap -Xmx64m. -XX:InitialHeapSize=67108864 -> 64MB; -XX:MaxHeapSize=67108864 -> 64MB
public class HeapCrash {
    public static void main(String[] args) throws InterruptedException {
        List<int[]> lista = new ArrayList<>();
        try {
            while (true) {
                lista.add(new int[1_000_000]); // ~4MB por array
                System.out.println("Objetos: " + lista.size());
            }
        } catch (OutOfMemoryError e){
            System.out.println(e);
            System.out.println("Se acabo la memoria de stack");
            System.out.println("Esperando 40 segundos para ejecutar comando jinfo si se configuro Xss...");
            Thread.sleep(1000*40);
            System.out.println("Programa terminado");
        }
    }
}
