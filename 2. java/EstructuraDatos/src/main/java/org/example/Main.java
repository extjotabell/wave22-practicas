package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Categoria chico = new Categoria(1, "Circuito chico", "2km por serval y arroyos", 1300,1500);
        Categoria medio = new Categoria(2, "Circuito medio", "5km por selva, arroyos y barro", 2000, 2300);
        Categoria avanzado = new Categoria(3, "Cirguito avanzado", "10km por selva,arroyos, barro y esacalda en piedra", 0, 2800);

        Persona cecilia = new Persona(1,"Cecilia", "Morlacchi", "12345678", 32);
        Persona emma = new Persona(2,"Emma", "Basualdo", "23456789", 2);
        Persona ivan = new Persona(3,"Ivan", "Basualdo", "45678912", 39);
        Persona mery = new Persona(4,"Mery", "Silva", "12345678", 60);

        medio.inscripcion(1, cecilia, medio.getId());
        chico.inscripcion(1, emma, chico.getId());
        avanzado.inscripcion(1, ivan, avanzado.getId());
        medio.inscripcion(2, mery, medio.getId());

        chico.mostrarParticipante();
        medio.mostrarParticipante();
        avanzado.mostrarParticipante();

        medio.desinscribrir(mery);

        medio.mostrarParticipante();

        int recaudacionChico;
        int recaudacionMedio;
        int recaudacionAvanzado;
        int recaudacionTotal;

        recaudacionChico = chico.montoApagar(emma);
        recaudacionMedio = medio.montoApagar(cecilia);
        recaudacionAvanzado = avanzado.montoApagar(ivan);
        recaudacionTotal = chico.montoApagar(emma) + medio.montoApagar(cecilia) + avanzado.montoApagar(ivan);

        System.out.println("------------------------------------------");
        System.out.println("Recaudacion chico: " + recaudacionChico);
        System.out.println("Recaudacion medio: " + recaudacionMedio);
        System.out.println("Recaudacion avanzado: " + recaudacionAvanzado);
        System.out.println("Recaudacion total: " + recaudacionTotal);

    }
}