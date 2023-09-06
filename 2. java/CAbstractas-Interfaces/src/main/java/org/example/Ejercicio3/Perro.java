package org.example.Ejercicio3;

public class Perro extends Animal implements Carnivoro{
    @Override
    public void hablar() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }
}
