package org.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Carrera {
    private String nombre;
    private Set<Inscripcion> inscripciones = new HashSet<>();

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public Carrera(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void inscribir(Inscripcion inscripcion){
        if(inscripcion.getPrecio() != 0 ){
            this.inscripciones.add(inscripcion);
        }
        else{
            System.out.println("No se puede inscribir a la carrera");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
