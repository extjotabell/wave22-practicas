package com.personaje.personajedisney.Interface;

import com.personaje.personajedisney.Dto.PersonajeDto;
import com.personaje.personajedisney.Models.Personaje;
import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> GetPersonaje(String name);
}
