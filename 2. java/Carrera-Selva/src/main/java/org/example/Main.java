package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, String> registered = new HashMap<>();
        List<Registration> inscripciones = new ArrayList<>();
        HashMap<String, Integer> hashMapCChico = new HashMap<>();
        hashMapCChico.put("Menor", 1300);
        hashMapCChico.put("Mayor", 1500);
        Category categoriaChico = new Category("CIRCUITO_CHICO",hashMapCChico);
        HashMap<String, Integer> hashMapCMedio = new HashMap<>();
        hashMapCMedio.put("Menor", 2000);
        hashMapCMedio.put("Mayor", 2300);
        Category categoriaMedio = new Category("CIRCUITO_MEDIO",hashMapCMedio);
        HashMap<String, Integer> hashMapCA = new HashMap<>();
        hashMapCA.put("Mayor", 2800);
        Category categoriaAvanzado = new Category("CIRCUITO_AVANZADO",hashMapCA);


        Participant corredor = new Participant(1, 123, "John", "Doe", 36, "12345", "23425", "O-");
        Participant corredor1 = new Participant(2, 124, "Joan", "Doan", 30, "12345", "23425", "A+");
        Participant corredor2c= new Participant(3, 125, "Juan", "Dominguez", 26, "12345", "23425", "O+");
        System.out.println("Hello world!");

        register(inscripciones, registered,corredor,categoriaChico);
        register(inscripciones, registered,corredor1,categoriaMedio);
        register(inscripciones, registered,corredor2c,categoriaAvanzado);

        System.out.println("Inscriptos categoria Chico: ");
        for (Registration inscripcion : inscripciones) {
            if (Objects.equals(inscripcion.getCategory().getTipoCategoria(),"CIRCUITO_CHICO")){
                System.out.println(inscripcion);
            }
        }

        unregister(inscripciones, registered, corredor);

        System.out.println("Inscriptos categoria Chico: ");
        for (Registration inscripcion : inscripciones) {
            if (Objects.equals(inscripcion.getCategory().getTipoCategoria(),"CIRCUITO_CHICO")){
                System.out.println(inscripcion);
            }
        }
    }

    public static void register(List<Registration> inscripciones, HashMap<Integer, String> inscriptos, Participant participante, Category categoria){
        inscriptos.put(participante.getDni(), categoria.getTipoCategoria());
        Registration inscripcion = new Registration(categoria, participante);
        participante.setCategory(categoria);
        inscripciones.add(inscripcion);
    }

    public static List<Registration> unregister(List<Registration> inscripciones, HashMap<Integer, String> inscriptos, Participant participante){
        inscriptos.remove(participante.getDni());
        participante.setCategory(null);
        inscripciones.removeIf(inscripcion -> inscripcion.getParticipant() == participante);
        return inscripciones;
    }
}