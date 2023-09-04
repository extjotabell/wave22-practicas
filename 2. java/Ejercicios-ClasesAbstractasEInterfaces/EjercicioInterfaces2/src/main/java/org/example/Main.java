package org.example;

import org.Models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Documento> documentos = List.of(
                new LibroPdf(8,"Ray Bradbury", "Farenheit 451", "Ciencia Ficcion"),
                new Curriculum("Luciana", new Persona("Luciana", 38832625,
                        List.of(new Skill("Java", "Basico"), new Skill("C#", "Intermedio")))),
                new Informe(1, "Luciana", 30, "Revisor verificado")
        );

        for(int i = 0; i < documentos.size(); i++)
        {
            documentos.get(i).imprimirDocumento();
        }
    }
}