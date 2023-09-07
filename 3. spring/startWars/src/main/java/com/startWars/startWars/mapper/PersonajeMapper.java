package com.startWars.startWars.mapper;

import com.startWars.startWars.dto.PersonajeDTO;
import com.startWars.startWars.model.Personaje;
import org.springframework.stereotype.Component;

@Component
public class PersonajeMapper {
    public PersonajeDTO trasnformarDTO(Personaje personaje) {
        PersonajeDTO personajedto = new PersonajeDTO(
                personaje.getName(),
                personaje.getHeight(),
                personaje.getHomeworld(),
                personaje.getMass(),
                personaje.getGender(),
                personaje.getSpecies()
        );
        return personajedto;
    }
}
