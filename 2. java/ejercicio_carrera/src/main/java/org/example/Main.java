package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void inscribir(List<Inscripcion> inscripciones, HashMap<String, Integer> inscriptos, Participante participante, Categoria categoria){
        if(!inscriptos.containsKey(participante.getDni())){
            inscriptos.put(participante.getDni(),categoria.getId());
            Inscripcion inscripcion = new Inscripcion(participante,categoria);
            inscripciones.add(inscripcion);
        }
    }
    public static List<Inscripcion> desinscribir(List<Inscripcion> inscripciones, HashMap<String, Integer> inscriptos, Participante participante){
        inscriptos.remove(participante.getDni());
        inscripciones.removeIf(inscripcion -> inscripcion.getParticipante() == participante);
        return inscripciones;
    }
    public static void main(String[] args) {
        HashMap<String, Integer> inscriptos= new HashMap<>();
        List<Inscripcion> inscripciones = new ArrayList<>();
        HashMap<String, Integer> hashMapCC = new HashMap<>();
        hashMapCC.put("Menor", 1300);
        hashMapCC.put("Mayor", 1500);
        Categoria categoria1 = new Categoria(1,"Circuito Chico","bla bla",hashMapCC);
        HashMap<String, Integer> hashMapCM = new HashMap<>();
        hashMapCM.put("Menor", 2000);
        hashMapCM.put("Mayor", 2300);
        Categoria categoria2 = new Categoria(2,"Circuito Medio","bla bla",hashMapCM);
        HashMap<String, Integer> hashMapCA = new HashMap<>();
        hashMapCA.put("Mayor", 2800);
        Categoria categoria3 = new Categoria(3,"Circuito Avanzado","bla bla",hashMapCA);

        Participante participante1 = new Participante("juan", "perez", "123456", "0+", "123123123", 14);
        Participante participante2 = new Participante("juan", "perez", "123456", "0+", "123123124", 20);
        Participante participante3 = new Participante("juan", "perez", "123456", "0+", "123123125", 30);

        inscribir(inscripciones, inscriptos,participante1,categoria1);
        inscribir(inscripciones, inscriptos,participante2,categoria1);
        inscribir(inscripciones, inscriptos,participante3,categoria1);

        System.out.println("Inscriptos categoria 1: ");
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == 1){
                System.out.println(inscripcion);
            }
        }

        desinscribir(inscripciones, inscriptos, participante1);

        System.out.println("Inscriptos categoria 1: ");
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria().getId() == 1){
                System.out.println(inscripcion);
            }
        }
        
    }

}