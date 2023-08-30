package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Map<Integer,Inscripcion> inscripciones = new HashMap<>();
    public static void main(String[] args) {
        //Inicialización de datos
        Categoria categoriaChico = new Categoria(1,"Circuito Chico","2 km por selva y arroyos.");
        Categoria categoriaMedio = new Categoria(2,"Circuito Medio","5 km por selva, arroyos y barro.");
        Categoria categoriaAvanzado = new Categoria(3,"Circuito Avanzado","10 km por selva, arroyos, barro y escalada en piedra.");
        Participante participante1 = new Participante(1,123,"Pepe","Fuentes",18,1234567890,1234567890,"O+");
        Participante participante2 = new Participante(2,456,"Jorge","Vechio",22,1234567890,1234567890,"A+");
        Participante participante3 = new Participante(3,789,"Juan","Rodan",41,1234567890,1234567890,"B+");
        Participante participante4 = new Participante(4,124,"Gabi","Gonzalez",16,1234567890,1234567890,"O-");
        //Inscripcion
        inscribir(participante1,categoriaAvanzado);//punto c
        inscribir(participante2,categoriaChico);//punto c
        inscribir(participante3,categoriaMedio);//punto c
        inscribir(participante4,categoriaAvanzado);//punto c. Valida que no se inscriba si es menor de edad y si es de categoria avanzado
        inscribir(participante4,categoriaMedio);//punto c.
        inscribir(participante4,categoriaChico);//punto c. No lo inscribe ya que ya se encuentra en el Hashmap

        //mostrarParticipantesPorCategoria(categoriaAvanzado);//punto d
        desinscribir(participante3);//punto e
        mostrarParticipantes();
        System.out.println(calcularTotal());//punto f
        System.out.println(calcularTotalPorCategoria(categoriaChico));//punto f
    }
    public static void inscribir(Participante participante,Categoria categoria){
        if (inscripciones.containsKey(participante.getDni()) || (participante.getEdad()<18 && categoria.getId()==3)) return;
        //else inscripciones.add(new Inscripcion(new Random(1).nextInt(1000),categoria,participante));
        else inscripciones.put(participante.getDni(),new Inscripcion(new Random(1).nextInt(1000),categoria,participante));
    }

    public static void desinscribir(Participante participante){
        inscripciones.remove(participante.getDni());
    }

    public static void mostrarParticipantes(){
        for (Map.Entry<Integer, Inscripcion> inscripcion: inscripciones.entrySet()) {
            System.out.println(inscripcion.toString());
        }
    }

    public static void mostrarParticipantesPorCategoria(Categoria categoria){
        for (Map.Entry<Integer, Inscripcion> inscripcion: inscripciones.entrySet()) {
            if (inscripcion.getValue().getCategoria().equals(categoria)) System.out.println(inscripcion.toString());
        }
    }

    public static int calcularTotal()
    {
        int totalRecaudado = 0;
        for (Map.Entry<Integer, Inscripcion> inscripcion: inscripciones.entrySet()) {
            totalRecaudado+=inscripcion.getValue().calcularMonto();
        }
        return totalRecaudado;
    }

    public static int calcularTotalPorCategoria(Categoria categoria)
    {
        int totalRecaudadoPorCategoria = 0;
        for (Map.Entry<Integer, Inscripcion> inscripcion: inscripciones.entrySet()) {
            if (inscripcion.getValue().getCategoria().equals(categoria)) {
                totalRecaudadoPorCategoria+=inscripcion.getValue().calcularMonto();
            }
        }
        return totalRecaudadoPorCategoria;
    }
}