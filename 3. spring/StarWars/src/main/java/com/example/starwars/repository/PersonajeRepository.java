package com.example.starwars.repository;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {
    private List<Personaje> personajeList;

    public PersonajeRepository() {
        this.personajeList = new ArrayList<>();

        personajeList.add(new Personaje(
                "Luke Skywalker", "Brown", "White", "Brown", "12/12/1990", "Male", "IDK", "IDKx2", 180, 80
        ));
    }

    public Personaje findByName(String name) {
        return this.personajeList.stream().filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase())).findFirst().orElse(null);
    }
}
