package com.ejercicios.starwars.service;

import com.ejercicios.starwars.dto.PersonajeDTO;


import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> getAll();
    List<PersonajeDTO> findByName(String name);
    void save(PersonajeDTO personajeDTO);
}
