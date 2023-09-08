package com.meli.personajesstarwars.service;

import com.meli.personajesstarwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {

    List<PersonajeDTO> findAll();
    List<PersonajeDTO> findByName(String name);

}
