package com.startWars.startWars.service;

import com.startWars.startWars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> buscarPorNombre(String nombre);
}
