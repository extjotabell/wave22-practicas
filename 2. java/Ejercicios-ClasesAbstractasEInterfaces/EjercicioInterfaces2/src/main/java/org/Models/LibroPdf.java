package org.Models;

import org.interfaces.Imprimible;

public class LibroPdf extends Documento {
    private String titulo;
    private String genero;
    public LibroPdf(int cantidadPaginas, String autor, String titulo, String genero) {
        super(cantidadPaginas, autor);
        this.titulo = titulo;
        this.genero = genero;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "autor='" + this.getAutor() + '\'' +
                ", paginas='" + this.getCantidadPaginas() + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimirDocumento()
    {
        super.imprimirDocumento();
        System.out.println(toString());
    }
}
