package com.example.deportistas.repository;

import com.example.deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository implements IPersonaRepository{
    List<Persona> personas;

    private void initialize(){
        var maria = new Persona("Maria", "Lopez", 51);
        var pablo = new Persona("Pablo", "Gomez", 40);
        var juana = new Persona("Juana", "Sanchez", 28);
        personas.add(maria);
        personas.add(pablo);
        personas.add(juana);
    }

    @Override
    public List<Persona> getAll() {
        initialize();
        return this.personas;
    }
}
