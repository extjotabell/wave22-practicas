package com.deportista.deportista.Service;

import com.deportista.deportista.DTO.DeporteDTO;
import com.deportista.deportista.DTO.PersonaDTO;
import com.deportista.deportista.Models.Deporte;
import com.deportista.deportista.Models.Persona;

import java.util.List;

public interface IPersonaService {

    List<DeporteDTO> GetAllDeporte();
    DeporteDTO GetByNameDeporte(String name);
    List<PersonaDTO> GetPersona();
}
