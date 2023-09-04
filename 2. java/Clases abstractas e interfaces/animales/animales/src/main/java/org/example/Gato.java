package org.example;

public class Gato extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Maiu! miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo royal cannin");
    }
}
