package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private int menores;
    private int mayores;
    private Map<Integer,Persona> participantes = new HashMap<>();

    public Categoria(int id, String nombre, String descripcion, int menores, int mayores){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.menores = menores;
        this.mayores = mayores;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getMenores() {
        return menores;
    }

    public int getMayores() {
        return mayores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMenores(int menores) {
        this.menores = menores;
    }

    public void setMayores(int mayores) {
        this.mayores = mayores;
    }

    public Map<Integer, Persona> getParticipantes() {
        return participantes;
    }

    public boolean inscripcion(int id , Persona persona, int id_categoria){
        if(id_categoria == 3 && persona.getEdad() < 18) {
            return false;
        }
        else{
            participantes.put(id,persona);
            return true;
        }
    }

    public int montoApagar(Persona persona){
        if(persona.getEdad() > 18){
            return this.mayores;
        }
        else{
            return this.menores;
        }
    }

    public void mostrarParticipante(){
        for (Map.Entry<Integer,Persona> participante : this.participantes.entrySet()){
            Integer id = participante.getKey();
            Persona persona = participante.getValue();
            System.out.println("El participante Nº:" + id + " " + "Es: " + persona);
        }
    }

    public void desinscribrir (Persona persona){
        for (Map.Entry<Integer,Persona> participante : this.participantes.entrySet()){
            Integer id = participante.getKey();
            Persona persona1 = participante.getValue();
            if(persona == persona1){
                this.participantes.remove(id);
            }
        }
    }
}
