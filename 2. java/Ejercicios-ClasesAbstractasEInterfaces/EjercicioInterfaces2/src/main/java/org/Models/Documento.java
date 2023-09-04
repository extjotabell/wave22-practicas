package org.Models;

import org.interfaces.Imprimible;

public abstract class Documento implements Imprimible{
    private int cantidadPaginas;
    private String autor;

    public Documento(int cantidadPaginas, String autor) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
    }

    public Documento(String autor) {
        this.autor = autor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void imprimirDocumento()
    {
        Imprimible.imprimir(this);
    }
}
