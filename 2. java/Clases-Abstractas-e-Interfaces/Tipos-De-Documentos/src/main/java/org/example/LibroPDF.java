package org.example;

public class LibroPDF implements Imprimible<LibroPDF>{
    private Integer paginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(Integer paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
        return "LibrosPDF{" +
                "paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir(LibroPDF libroPDF) {
        System.out.println(libroPDF.toString());
    }
}