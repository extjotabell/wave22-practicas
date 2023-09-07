package com.example.starwars.service;

import com.example.starwars.dtos.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    List<PersonajeDTO> getPersonajeByName(String name);

}
