package com.mercadolibre.ejerciciopersonajes.service;

import com.mercadolibre.ejerciciopersonajes.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {

    List<PersonajeDTO> getAllPersonajesByName(String name);
    List<PersonajeDTO> getAllPersonajes();

}
