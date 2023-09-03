package org.example.Clases;

import org.example.Interfaces.carnivoro;

public class Gato extends Animal implements carnivoro {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau! mi nombre es "+ this.nombre);
    }

    @Override
    public void comerCarne() {
        System.out.println(this.nombre+" esta comiendo carne!!");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
