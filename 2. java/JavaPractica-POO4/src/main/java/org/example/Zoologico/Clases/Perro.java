package org.example.Zoologico.Clases;

import org.example.Zoologico.Interfaces.ComerCarne;

public class Perro extends Animal implements ComerCarne {
    @Override
    public void EmitirSonido() {
        System.out.println("GUAUU");
    }

    @Override
    public void ComiendoCarne() {
        System.out.println("Comiendo carne...");
    }
}
