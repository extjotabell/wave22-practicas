package Interfaces;

import models.Animal;

import javax.swing.plaf.basic.BasicOptionPaneUI;

public interface Comestible {
    void comerCarne();
    void comerHierba();
    void comerAnimal(Animal animal);
}
