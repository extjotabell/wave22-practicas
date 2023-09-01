package org.example;

public interface Carnivoro extends Alimentacion{

    void comerCarne();

    @Override
    default void comer() {
        comerCarne();
    }
}
