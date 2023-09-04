package org.meli;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Categoria chico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria medio = new Categoria(1, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria avanzado = new Categoria(1, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        Participante juana = new Participante(1, 34567890, "Juana", 30, 43343493, 22342344, "A+");
        Participante pablo = new Participante(2, 445667890, "Pablo", 21, 43343493, 22342344, "A+");
        Participante lola = new Participante(3, 64347890, "Lola", 16, 43343493, 22342344, "A+");

        Inscripcion inscripcion1 = new Inscripcion(1, chico, juana);
        Inscripcion inscripcion2 = new Inscripcion(1, avanzado, pablo);
        Inscripcion inscripcion3 = new Inscripcion(1, medio, lola);

        List<Inscripcion> inscripciones = new ArrayList<>();
        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);

        System.out.println("");

        for (Inscripcion i : inscripciones) {
            System.out.println("Inscriptos a la categoria: " + i.getCategoria().getNombre() + " - Datos del participante: " + i.getParticipante().toString());
        }

        inscripciones.remove(2);

        System.out.println("");

        System.out.println("|| Actualización luego de remover participante ||");

        System.out.println("");

        for (Inscripcion i : inscripciones) {
            System.out.println("Inscriptos a la categoria: " + i.getCategoria().getNombre() + " - Datos del participante: " + i.getParticipante().toString());
        }

        Double montoTotal = 0.0;

        System.out.println("");

        for (int i = 0; i < inscripciones.size() ; i++) {
            System.out.println("Total recaudado en categoria "
                    + inscripciones.get(i).getCategoria().getNombre()
                    + " = $" + inscripciones.get(i).getMonto());
            montoTotal += inscripciones.get(i).getMonto();
        }

        System.out.println("Recaudacion total carrera $" + montoTotal);



    }
}

