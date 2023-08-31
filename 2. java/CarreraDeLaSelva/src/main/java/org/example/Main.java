package org.example;

import javax.swing.plaf.basic.BasicTreeUI;

public class Main {
    public static void main(String[] args) {

        Carrera carreraSelva = new Carrera("Carrera de la selva");
        Categoria categoriaUno = new Categoria(1, "circuito chico", "2km por selva y arroyos");
        Categoria categoriaDos = new Categoria(2, "Circuito medio", "5km por selva, arroyos y barro");
        Categoria categoriaTres = new Categoria(3, "Circuito avanzado", "10km por selva, arroyos, barro y escalada en piedra");

        Participante participanteUno = new Participante(1, "41998765", "Magui", "Cagna", 34, "1176549876", "1176549874", "a+");
        Participante participanteDos = new Participante(2, "41998762", "Solange", "Recayte", 18, "1176549871", "1176549871", "b+");
        Participante participanteTres = new Participante(3, "41998764", "Valentina", "Gottelli", 15, "1176549872", "1176549873", "b-");
        Participante participanteCuatro = new Participante(4, "11549871", "Pepito", "Suarez", 14, "1176549873", "1176549879", "0");

        Inscripcion inscripcionUno = new Inscripcion(1, categoriaTres, participanteUno);
        inscripcionUno.setearPrecioInscripcion();
        Inscripcion inscripcionDos = new Inscripcion(2, categoriaUno, participanteDos);
        inscripcionDos.setearPrecioInscripcion();
        Inscripcion inscripcionTres = new Inscripcion(3, categoriaTres, participanteTres);
        inscripcionTres.setearPrecioInscripcion();
        Inscripcion inscripcionCuatro = new Inscripcion(4, categoriaUno, participanteCuatro);
        inscripcionCuatro.setearPrecioInscripcion();

        carreraSelva.inscribir(inscripcionUno);
        carreraSelva.inscribir(inscripcionDos);
        carreraSelva.inscribir(inscripcionTres);
        carreraSelva.inscribir(inscripcionCuatro);

        for (Inscripcion ins :
                carreraSelva.getInscripciones()) {
            System.out.println(ins);
        }



    }
}