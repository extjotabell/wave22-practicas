package org.example;

public class Gato extends Animal implements Herviboro, Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miau 🐈");
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
