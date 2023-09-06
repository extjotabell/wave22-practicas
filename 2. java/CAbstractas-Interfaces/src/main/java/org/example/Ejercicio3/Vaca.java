package org.example.Ejercicio3;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void hablar() {
        System.out.println("Muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("comiendo pasto");
    }
}
