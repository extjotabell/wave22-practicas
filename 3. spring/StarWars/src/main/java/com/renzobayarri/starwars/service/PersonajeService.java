package com.renzobayarri.starwars.service;

import com.renzobayarri.starwars.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    List<PersonajeDTO> getAll();

    List<PersonajeDTO> getByName(String name);
}
