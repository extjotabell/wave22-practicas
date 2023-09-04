package org.example;

public class Perro extends Animal implements Carnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Guau! Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
