package org.example.Clases;

import org.example.Interfaces.Imprimible;

public class Informes implements Imprimible {
    private Integer longitud;
    private Integer cantidadPaginas;
    private String autor;
    private String revisor;

    public Informes(Integer longitud, Integer cantidadPaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    @Override
    public void imprimir() {
        System.out.println("-----------------------------\n" +
                "Longitud: "+this.longitud+" palabras" +
                "Autor: "+this.autor+"\n" +
                "Revisor: "+this.revisor+"\n" +
                "Paginas 1/"+this.cantidadPaginas);
    }
}
