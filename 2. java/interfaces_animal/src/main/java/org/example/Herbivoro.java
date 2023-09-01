package org.example;

public interface Herbivoro extends Alimentacion {

    void comerHierba();

    @Override
    default void comer() {
        comerHierba();
    }
}
