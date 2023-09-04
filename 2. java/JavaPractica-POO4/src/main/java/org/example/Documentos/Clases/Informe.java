package org.example.Documentos.Clases;

public class Informe extends Documento{

    private String texto;
    private int cantPag;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantPag, String autor, String revisor) {
        this.texto = texto;
        this.cantPag = cantPag;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
