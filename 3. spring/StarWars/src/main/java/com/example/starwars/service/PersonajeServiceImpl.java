package com.example.starwars.service;

import com.example.starwars.DTO.PersonajeDTO;
import com.example.starwars.model.Personaje;
import com.example.starwars.repository.PersonajeRepository;
import com.example.starwars.repository.PersonajeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService{

    @Autowired
    PersonajeRepository repository;

    @Override
    public List<PersonajeDTO> getAll() {
        List<Personaje> listaPersonajes = repository.getAll();
        List<PersonajeDTO> listaPersonajesDTO = new ArrayList<>();

        for (Personaje p : listaPersonajes){
            PersonajeDTO personajeDTO = new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies());
            listaPersonajesDTO.add(personajeDTO);
        }

        return listaPersonajesDTO;

    }

    @Override
    public List<PersonajeDTO> getPersonajes(String name) {
        List<Personaje> listaPersonajes = repository.getAll();
        List<PersonajeDTO> listaPersonajesDTO = new ArrayList<>();

        listaPersonajes = repository.getPersonajes(name);

        for (Personaje p : listaPersonajes){
            PersonajeDTO personajeDTO = new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies());
            listaPersonajesDTO.add(personajeDTO);
        }

        return listaPersonajesDTO;
    }

}
