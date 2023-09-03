package org.example.Clases;

import org.example.Interfaces.herviboro;

public class Vaca extends Animal implements herviboro {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu! mi nombre es "+ this.nombre);
    }

    @Override
    public void comerHierba() {
        System.out.println(this.nombre+ " esta pastando!!!");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
