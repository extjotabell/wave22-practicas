package org;

public class LibroPdf extends Documento {

    private String nombre;

    private String autor;

    public LibroPdf(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Autor: " + autor);
    }
}
