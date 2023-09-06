package org.example.Ejercicio2;

public class LibroPdf implements Imprimible<LibroPdf>{
    private int cantidadPag;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPdf(int cantidadPag, String nombreAutor, String titulo, String genero) {
        this.cantidadPag = cantidadPag;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadPag() {
        return cantidadPag;
    }

    public void setCantidadPag(int cantidadPag) {
        this.cantidadPag = cantidadPag;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
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
                "cantidadPag=" + cantidadPag +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir(LibroPdf libroPdf) {
        System.out.println("Imprimiendo el libro en pdf: "+libroPdf);
    }
}
