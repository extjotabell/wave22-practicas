package org.example;

import java.util.*;

public class Main {
    private static Map<String,Integer> preciosCircuitoChico = new HashMap<>();
    private static Map<String,Integer> preciosCircuitoMedio = new HashMap<>();
    private static Map<String,Integer> preciosCircuitoAvanzado = new HashMap<>();

    public static void main(String[] args) {

        // Inicializar precios constantes
        initializePrecios();

        // Inicializar circuitos con precios
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2km por selva y arroyos.", preciosCircuitoChico);
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5km por selva y arroyos.", preciosCircuitoMedio);
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10km por selva, arroyos, barro y escalada en piedra.", preciosCircuitoAvanzado);

        // Inicializar Participantes
        Persona participanteUno = new Persona("Juan", "Pepe", "123456", "O+", "121212", 14);
        Persona participanteDos = new Persona("Juan2", "Pepe2", "123456", "O+", "121212", 18);
        Persona participanteTres = new Persona("Juan3", "Pepe3", "123456", "O+", "121212", 14);
        Persona participanteCuatro = new Persona("Juan4", "Pepe4", "123456", "O+", "121212", 18);
        Persona participanteSeis = new Persona("Juan6", "Pepe6", "123456", "O+", "121212", 18);

        // Inicializar Inscripciones;
        Set<Inscripcion> inscripciones = new HashSet<>();

        inscripciones.add(new Inscripcion(1, circuitoChico, participanteUno));
        inscripciones.add(new Inscripcion(2, circuitoChico, participanteDos));
        inscripciones.add(new Inscripcion(3, circuitoMedio, participanteTres));
        inscripciones.add(new Inscripcion(4, circuitoMedio, participanteCuatro));
        inscripciones.add(new Inscripcion(6, circuitoAvanzado, participanteSeis));
        inscripciones.add(new Inscripcion(7, circuitoAvanzado, participanteDos));

        System.out.println(inscripciones.size());

    }

    private static void initializePrecios(){
        preciosCircuitoChico.put("Menor", 1300);
        preciosCircuitoChico.put("Mayor", 1500);

        preciosCircuitoMedio.put("Menor", 2000);
        preciosCircuitoMedio.put("Mayor", 2300);

        preciosCircuitoAvanzado.put("Mayor", 2800);
    }
}