package org.example;

public class Vaca extends Animal implements Hervivoro{
    @Override
    void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comerHierva() {
        System.out.println("Comiendo pasto");
    }
}
