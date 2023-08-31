package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Competencia carrera = crearCompetencia();

        carrera.mostrarParticipantes();

        carrera.desinscribirParticipante(carrera.categorias.get(0).participantes.get(1), carrera.categorias.get(0));

        carrera.categorias.get(0).MostrarParticipantes();

        gananciaPorCategoria(carrera);
        gananciaPorCompetencia(carrera);
    }
    public static Competencia crearCompetencia()
    {Competencia carrera = new Competencia("Carrera");

        carrera.agregarCategoria(new Categoria("Circuito Chico", 1300, 1500));
        carrera.agregarCategoria(new Categoria("Circuito Medio", 2300, 2000));
        carrera.agregarCategoria(new Categoria("Circuito Grande", 2800));

        Participante participante1 = new Participante(1, 12345678, "Juan", "Pérez", 25, 123456789, 987654321, "A+");
        Participante participante2 = new Participante(2, 23456789, "María", "López", 30, 987654321, 123456789, "B-");
        Participante participante3 = new Participante(3, 34567890, "Carlos", "García", 5, 789456123, 654321987, "O+");
        Participante participante4 = new Participante(4, 45678901, "Ana", "Martínez", 28, 456123789, 789654123, "AB-");
        Participante participante5 = new Participante(5, 56789012, "Luis", "Rodríguez", 14, 321789456, 987123654, "A-");
        Participante participante6 = new Participante(6, 67890123, "Laura", "Fernández", 35, 654987123, 123789456, "B+");
        Participante participante7 = new Participante(7, 78901234, "Pedro", "Gómez", 40, 789654321, 456321789, "O-");
        Participante participante8 = new Participante(8, 89012345, "Sofía", "Díaz", 5, 987321654, 321654987, "AB+");
        Participante participante9 = new Participante(9, 123233, "Ana", "Gutierrez", 22, 23213243, 343654, "A+");

        carrera.inscribirParticipante(participante1, carrera.categorias.get(0));
        carrera.inscribirParticipante(participante2, carrera.categorias.get(0));
        carrera.inscribirParticipante(participante8, carrera.categorias.get(0));
        carrera.inscribirParticipante(participante4, carrera.categorias.get(1));
        carrera.inscribirParticipante(participante5, carrera.categorias.get(1));
        carrera.inscribirParticipante(participante6, carrera.categorias.get(1));
        carrera.inscribirParticipante(participante7, carrera.categorias.get(2));
        carrera.inscribirParticipante(participante3, carrera.categorias.get(2));
        carrera.inscribirParticipante(participante9, carrera.categorias.get(2));
        return carrera;
    }

    public static void gananciaPorCategoria(Competencia competencia)
    {
        System.out.println("---Ganancias por categorias---");
        for(int i = 0; i < competencia.categorias.size(); i++)
        {
            System.out.println("Categoria: " + competencia.categorias.get(i).nombre + " - Ganancias: $" + competencia.categorias.get(i).ganancias());
        }
    }
    public static void gananciaPorCompetencia(Competencia competencia)
    {
        System.out.println("---Ganancias totales de la competencia---");
        System.out.println("$" + competencia.gananciasTotales());
    }
}