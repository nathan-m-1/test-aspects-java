package com.test.interface_multiple_inheritance;

public interface Localizable {

    default void girar() {
        System.out.println("Girando desde interfaz Localizable");
    }
}
