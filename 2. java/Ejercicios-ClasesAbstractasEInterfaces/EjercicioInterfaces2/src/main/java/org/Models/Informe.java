package org.Models;

public class Informe extends Documento{
    public int longitudTexto;
    public String revisor;

    public Informe(int cantidadPaginas, String autor, int longitudTexto, String revisor) {
        super(cantidadPaginas, autor);
        this.longitudTexto = longitudTexto;
        this.revisor = revisor;
    }

    public int getLongitudTexto() {
        return longitudTexto;
    }

    public void setLongitudTexto(int longitudTexto) {
        this.longitudTexto = longitudTexto;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "autor='" + super.getAutor() + '\'' +
                ", paginas='" + super.getCantidadPaginas() + '\'' +
                ", longitudTexto=" + longitudTexto +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimirDocumento()
    {
        super.imprimirDocumento();
        System.out.println(toString());
    }
}
