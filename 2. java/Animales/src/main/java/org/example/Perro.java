package org.example;

public class Perro extends Animal implements Herviboro, Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Guau 🐶");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne... 🥩");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba... 🌿");
    }
}
