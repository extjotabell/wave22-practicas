package model;

import gustosAlimenticios.Carnivoros;

public class Gato extends Animal implements Carnivoros {
    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiendo carne");
    }
}
