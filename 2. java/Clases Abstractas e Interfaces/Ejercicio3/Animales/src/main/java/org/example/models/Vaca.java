package org.example.models;

public class Vaca extends Animal implements IAlimentarHierba {
    @Override
    public String emitirSonido() {
        return super.emitirSonido() + "Muuuu muuu";
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca esta comiendo hierba");
    }
}