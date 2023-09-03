package org.example.Clases;

import org.example.Interfaces.Imprimible;

public class LibrosPDF  implements Imprimible {

    private Integer cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibrosPDF(Integer cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("-----------------------------\n" +
                "Titulo: "+this.titulo+"\n" +
                "Autor: "+this.autor+"\n" +
                "Genero: "+this.genero+"\n" +
                "Paginas 1/"+this.cantidadDePaginas);
    }
}
