package org.example.models;

public interface Documento {
    static <T> void imprimir(T objeto) {
        System.out.println("Se imprime el contenido del documento: " + objeto);
    }
}
