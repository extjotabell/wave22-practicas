package com.deportista.deportista.Repository;

import com.deportista.deportista.DTO.PersonaDTO;
import com.deportista.deportista.Models.Deporte;
import com.deportista.deportista.Models.Persona;

import java.util.List;

public interface IPersonaRepository {

    List<Deporte> GetAllDeporte();
    Deporte GetByNameDeporte(String name);
    List<Persona> GetPersona();


}
