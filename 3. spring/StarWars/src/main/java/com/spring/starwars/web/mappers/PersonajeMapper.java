package com.spring.starwars.web.mappers;

import com.spring.starwars.entities.Personaje;
import com.spring.starwars.web.dto.PersonajeDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface PersonajeMapper {
    Personaje toEntity(PersonajeDTO personajeDTO);
    PersonajeDTO toDto(Personaje personaje);
}
