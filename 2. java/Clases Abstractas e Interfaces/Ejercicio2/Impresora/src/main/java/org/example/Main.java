package org.example;

import org.example.models.Persona;
import org.example.models.Curriculum;
import org.example.models.Documento;
import org.example.models.Libro;
import org.example.models.Informe;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona personaUno = new Persona("Julio", "42804438", 23,
                "alvarezjuliojoel@gmail.com");
        List<String> habilidades  = new ArrayList<>();
        habilidades.add("Pensar");
        habilidades.add("Planear");
        habilidades.add("Programar");

        personaUno.setHabilidades((ArrayList<String>) habilidades);

        Curriculum curriculum = new Curriculum();
        curriculum.setPersona(personaUno);

        Documento.imprimir(curriculum);

        Libro libro = new Libro(970, "Jorge Luis Borges", "Ficciones", "Literatura");
        Documento.imprimir(libro);

        Informe informe = new Informe("Se estima una subida de la infacion del 70% para el proximo año",
                56, "Gustavo Lazzari", "Economia en tiempos kirchernistas",
                "Paper");
        Documento.imprimir(informe);
    }
}