package com.example.starwars.mapper;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.model.Personaje;
import org.springframework.stereotype.Component;

@Component
public class StarWarsMapper {

    public PersonajeDTO toDTO(Personaje personaje){
        return PersonajeDTO.builder()
                .gender(personaje.getGender())
                .height(personaje.getHeight())
                .homeworld(personaje.getHomeworld())
                .mass(personaje.getMass())
                .species(personaje.getSpecies())
                .name(personaje.getName())
                .build();
    }
}
