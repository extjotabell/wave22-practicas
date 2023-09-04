package org.example.Zoologico.Clases;

import org.example.Zoologico.Interfaces.ComerHierba;

public class Vaca extends Animal implements ComerHierba {
    @Override
    public void EmitirSonido() {
        System.out.println("MUUUU");
    }

    @Override
    public void ComiendoHierba() {
        System.out.println("Comiendo pasto...");
    }
}
