package org.example;

public class Vaca extends Animal implements Herbivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuu");
    }

    @Override
    public void comer() {
        this.comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pastito, saludable");
    }
}