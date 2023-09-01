package model;

public class Informe implements Imprimible {
    private String texto;
    private int cantidadPaginas;

    private Autor autor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    public Informe() {
    }

    public Informe(String texto, int cantidadPaginas, Autor autor, Persona revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    private Persona revisor;

    @Override
    public void imprimir() {
        System.out.println("Imprimiento el informe");
    }
}
