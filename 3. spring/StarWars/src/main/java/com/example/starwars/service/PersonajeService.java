package com.example.starwars.service;

import com.example.starwars.DTO.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    List<PersonajeDTO> getAll();

    List<PersonajeDTO> getPersonajes(String name);

}
