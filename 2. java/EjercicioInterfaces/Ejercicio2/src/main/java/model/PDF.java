package model;

public class PDF implements Imprimible {
    private int cantidadPaginas;
    private Autor autor;

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public PDF(int cantidadPaginas, Autor autor) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir documento PDF");
    }
}
