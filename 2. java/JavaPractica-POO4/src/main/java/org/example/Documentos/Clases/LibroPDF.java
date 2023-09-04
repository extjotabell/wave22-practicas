package org.example.Documentos.Clases;

public class LibroPDF extends Documento{
    private int cantPag;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantPag, String nombreAutor, String titulo, String genero) {
        this.cantPag = cantPag;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
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
}
