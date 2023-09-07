package com.example.starwars.service;

import com.example.starwars.dtos.PersonajeDTO;
import com.example.starwars.models.Personaje;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.repository.PersonajeRepositoryIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceIMP implements PersonajeService{

    @Autowired

    IPersonajeRepository repo;

    @Override
    public List<PersonajeDTO> getPersonajeByName(String name) {
        name.toLowerCase();
        List<Personaje> personajes = repo.getAllPersonajes();
        List<PersonajeDTO> dtoPersonaje = new ArrayList<>();

        dtoPersonaje = personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name))
                .map(personaje -> {
                    String nombre = personaje.getName();
                    Integer height = personaje.getHeight();
                    Integer mass = personaje.getMass();
                    String gender = personaje.getGender();
                    String homeworld = personaje.getHomeworld();
                    String sprecies = personaje.getSprecies();

                    return new PersonajeDTO(nombre,height,mass,gender,homeworld,sprecies);

                })
                .collect(Collectors.toList());

        return dtoPersonaje;
    }



}
