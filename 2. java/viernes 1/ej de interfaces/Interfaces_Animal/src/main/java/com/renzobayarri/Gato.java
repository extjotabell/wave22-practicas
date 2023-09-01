package com.renzobayarri;

public class Gato extends Animal{
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo atún");
    }
}
