package com.test.records;

public class TestRecord {

    public static void main(String[] args) {
        Persona persona = new Persona("Flor", 30);
        System.out.println(persona.name());
        System.out.println(persona.age());
        System.out.println(persona.toString());
    }
}
