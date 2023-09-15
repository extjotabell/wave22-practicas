package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> habilidadesCV = new ArrayList<String>(List.of("Programar", "Documentar", "Deployar"));

        Curriculum cv = new Curriculum("Ana Lopez", habilidadesCV);
        Informe informe = new Informe(300, 300, "Borges", "Maria");
        LibroPDF libro = new LibroPDF(400, "Juan Román", "Libro de Fútbol", "Deporte");
        cv.imprimir(cv);
        informe.imprimir(informe);
        libro.imprimir(libro);
    }
}