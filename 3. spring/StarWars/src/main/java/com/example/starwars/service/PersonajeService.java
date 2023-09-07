package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.model.Personaje;
import com.example.starwars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    IPersonajeRepository repository;

    @Override
    public List<PersonajeDTO> searchByName(String searchName) {
        List<Personaje> personajesBySearchName = repository.getBySearchName(searchName);
        List<PersonajeDTO> personajeDTOBySearchName = new ArrayList<>();
        for (Personaje personaje: personajesBySearchName) {
            PersonajeDTO personajeDTO = new PersonajeDTO(personaje.getName(), personaje.getHeight(),personaje.getMass(),personaje.getGender(), personaje.getHomeworld(),personaje.getSpecies());
            personajeDTOBySearchName.add(personajeDTO);
        }
        return personajeDTOBySearchName;
    }
}
