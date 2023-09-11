package com.ejercicioStarWars.ejercicioStarWars.service;

import com.ejercicioStarWars.ejercicioStarWars.dto.PersonajeDTO;

import java.util.List;

public interface IServiceStarWars {
    List<PersonajeDTO> searchPersonajes(String name);
}
