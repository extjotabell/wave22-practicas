package org.example.Ejercicio3;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void hablar() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo atun");
    }
}
