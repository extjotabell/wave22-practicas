package org;

public class Informe extends Documento{

    private String texto;

    private int paginas;

    private String autor;

    private String revisor;

    public Informe(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Texto: " + texto);
        System.out.println("Páginas: " + paginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }
}
