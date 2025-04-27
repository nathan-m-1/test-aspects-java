package com.test.interface_multiple_inheritance;

public class Carro implements Manejable, Localizable{
    @Override
    public void girar() {
        Manejable.super.girar();
    }
}
