package model;

import gustosAlimenticios.Carnivoros;

public class Perro extends Animal implements Carnivoros {
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro esta comiendo carne");
    }
}
