package com.covid19.covid19.repositorios;

import com.covid19.covid19.entidades.Persona;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPersona {

    public static List<Persona> personas = new ArrayList<>();

    public void agregarPersona(Persona persona){
        personas.add(persona);
    }

    public static List<Persona> getPersonas() {
        return personas;
    }
}
