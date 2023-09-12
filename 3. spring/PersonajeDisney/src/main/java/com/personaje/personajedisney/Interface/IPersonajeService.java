package com.personaje.personajedisney.Interface;

import com.personaje.personajedisney.Dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> GetPersonaje(String name);
}
