package org.example;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuu 🐮");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba... 🌿");
    }
}
