package com.ejercicioStarWars.ejercicioStarWars.service;

import com.ejercicioStarWars.ejercicioStarWars.dto.PersonajeDTO;
import com.ejercicioStarWars.ejercicioStarWars.repository.IRepositoryStarWars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceStarWars implements IServiceStarWars{
    @Autowired
    IRepositoryStarWars repository;

    @Override
    public List<PersonajeDTO> searchPersonajes(String name) {
        return repository.getAllPersonajes().stream()
                .filter(personaje -> personaje.getName().contains(name))
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(),
                        personaje.getMass(), personaje.getGender(), personaje.getHomeWorld(),
                        personaje.getSpecies()))
                .toList();
    }
}
