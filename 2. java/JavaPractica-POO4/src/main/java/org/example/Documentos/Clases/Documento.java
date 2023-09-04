package org.example.Documentos.Clases;

import org.example.Documentos.Interfaces.Imprimir;

public abstract class Documento implements Imprimir {
    @Override
    public String imprimir(String doc) {
        return "Imprimiendo..." + doc;
    }

}
