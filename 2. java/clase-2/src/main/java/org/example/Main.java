package org.example;

import java.util.ArrayList;
import java.util.List;

class Categoria{
    int id;
    String nombre;
    String descripcion;

    public Categoria(int id, String nombre, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }
}

class Participante{
    String nombre;
    int edad;

    public Participante(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}

class Inscripcion{

    int id;
    Categoria categoria;
    Participante participante;
    int monto;

    public Inscripcion(int id, Categoria categoria, Participante participante){
        int edad = participante.getEdad();
        int categoria_id = categoria.getId();

        int monto;

        // verificar categoria
        if (categoria_id == 1){
            // verificar edad
            if (edad < 18) {
                monto = 1300;
            } else {
                monto = 1500;
            }
        } else if (categoria_id == 2){
            // verificar edad
            if (edad < 18) {
                monto = 2000;
            } else {
                monto = 2300;
            }
        } else {
            // verificar edad
            if (edad < 18) {
                // Inscripcion no valida, crear caso
                monto = 9999;
            } else {
                monto = 2800;
            }
        }

        this.monto = monto;
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
    }

    public int getMonto() {
        return monto;
    }

    public Participante getParticipante() {
        return participante;
    }
}

public class Main {

    public static void main(String[] args) {
        Categoria chico = new Categoria(1, "Circuito Chico", "2km");
        Categoria mediano = new Categoria(2, "Circuito Mediano", "5km");
        Categoria avanzado = new Categoria(3, "Circuito Avanzado", "10km");

        List<Inscripcion> participantesIns = new ArrayList<Inscripcion>();

        Participante juan = new Participante("Juan", 18);
        Participante diego = new Participante("Diego", 16);
        Participante camila = new Participante("Camila", 21);

        Inscripcion aux = new Inscripcion(1, chico, juan);
        participantesIns.add(aux);
        aux = new Inscripcion(2, chico, diego);
        participantesIns.add(aux);
        aux = new Inscripcion(3, chico, camila);
        participantesIns.add(aux);

        for(Inscripcion persona: participantesIns) {
            System.out.println("Nombre del participante: " + persona.getParticipante().getNombre());
        }

        System.out.println("Monto a pagar del participante: " + aux.getMonto());

    }
}