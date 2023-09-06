package com.spring.deportistas.services;

import com.spring.deportistas.entities.Persona;
import com.spring.deportistas.web.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
    List<PersonaDTO> findAllSportPeople();
}
