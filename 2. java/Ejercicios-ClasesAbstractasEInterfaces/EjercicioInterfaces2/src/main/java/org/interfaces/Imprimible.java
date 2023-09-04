package org.interfaces;

import org.Models.Documento;

public interface Imprimible {
    static void imprimir(Documento documento) {
        System.out.println("Imprimiendo documento: " + documento.getClass().getSimpleName());
    }
}
