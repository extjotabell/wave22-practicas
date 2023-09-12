package com.deportista.deportista.Repository;

import com.deportista.deportista.Models.Deporte;
import com.deportista.deportista.Models.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository implements IPersonaRepository{

    List<Persona> personaList = new ArrayList<>();
    List<Deporte> deporteList = new ArrayList<>();

    public PersonaRepository(){

        deporteList.add(new Deporte(1,"Futbol","medio"));
        deporteList.add(new Deporte(2,"Voley","dificil"));
        deporteList.add(new Deporte(3,"paddel","facil"));

        personaList.add(new Persona("Sol","Recayte",30,new Deporte(1,"Futbol","medio")));
        personaList.add(new Persona("dani","Fimiani",30,new Deporte(2,"Voley","dificil")));
        personaList.add(new Persona("Orion","Fimiani",8,new Deporte(3,"paddel","facil")));
    }


    @Override
    public List<Deporte> GetAllDeporte() {
        return this.deporteList;
    }

    @Override
    public Deporte GetByNameDeporte(String name) {
        return this.deporteList.stream().filter(x->x.getNombre().toLowerCase().equals(name.toLowerCase())).findFirst().get();
    }

    @Override
    public List<Persona> GetPersona() {
        return this.personaList;
    }
}
