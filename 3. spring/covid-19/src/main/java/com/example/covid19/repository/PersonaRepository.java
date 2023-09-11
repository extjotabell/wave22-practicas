package com.example.covid19.repository;

import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository implements IPersonaRepository{
    List<Persona> personas = new ArrayList<>();

    private void initialize(){
        Persona p1 = new Persona(1, "Maria", "Perez", 80, List.of(new Sintoma("Tos")));
        Persona p2 = new Persona(2, "Enzo", "Fernandez", 21, List.of(new Sintoma("Fiebre")));
        Persona p3 = new Persona(2, "Sandra", "Dominguez", 30, List.of(new Sintoma("Perdida de olfato")));
        Persona p4 = new Persona(3, "Carla", "Sanchez", 60, List.of(new Sintoma("Fiebre")));
        this.personas.add(p1);
        this.personas.add(p2);
        this.personas.add(p3);
        this.personas.add(p4);
    }
    @Override
    public List<Persona> getAll() {
        if(this.personas.isEmpty()){
            initialize();
        }
        return this.personas;
    }
}
