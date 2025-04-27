package com.test.interface_multiple_inheritance;

public interface Manejable {

    default void girar() {
        System.out.println("Girando desde interfaz Manejable");
    }
}
