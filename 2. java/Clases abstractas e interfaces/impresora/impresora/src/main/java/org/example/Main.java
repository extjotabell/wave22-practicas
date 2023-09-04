package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Impresora impresora = new Impresora();
        Curriculum cv = new Curriculum("Ana Lopez", "Ingenieria en Sistemas - UBA",
                "Software Developer en Mercado Libre",
                "19/03/1995", 19382894, "analopez@gmail.com",
                List.of(new String[]{"Java", "Python"}));
        Informe informe = new Informe(300, 300, "Pedro", "Maria");
        LibroPDF libro = new LibroPDF(400, "Juan Lopez", "Libro de Historia", "Historia");
        impresora.print(cv);
        impresora.print(informe);
        impresora.print(libro);
    }
}