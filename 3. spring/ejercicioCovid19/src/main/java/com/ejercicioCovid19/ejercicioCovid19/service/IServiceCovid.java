package com.ejercicioCovid19.ejercicioCovid19.service;

import com.ejercicioCovid19.ejercicioCovid19.dto.PersonaRiesgoDTO;
import com.ejercicioCovid19.ejercicioCovid19.dto.SintomaDTO;
import com.ejercicioCovid19.ejercicioCovid19.dto.SintomaGravedadDTO;

import java.util.List;

public interface IServiceCovid {
    List<SintomaDTO> mostrarSintomas();
    SintomaGravedadDTO buscarSintoma(String name);
    List<PersonaRiesgoDTO> mostrarPersonasDeRiesgo();
}
