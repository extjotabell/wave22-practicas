package org.example;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Miauuuuuu");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne ñam ñam");
    }
}
