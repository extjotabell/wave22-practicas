package org.example.Zoologico.Clases;

import org.example.Zoologico.Interfaces.ComerCarne;
import org.example.Zoologico.Interfaces.ComerHierba;

public class Gato extends Animal implements ComerCarne {
    @Override
    public void EmitirSonido() {
        System.out.println("MIAUU");
    }

    @Override
    public void ComiendoCarne() {
        System.out.println("Comiendo carne...");
    }
}
