package org.example;

public class Perro extends Animal implements Carnivoro{


    @Override
    public void emitirSonido() {
        System.out.println("guau guau");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    public void comerCarne() {
        System.out.println("Como carne ñam ñam");
    }
}
