package com.ejercicioCovid19.ejercicioCovid19.service;

import com.ejercicioCovid19.ejercicioCovid19.dto.PersonaRiesgoDTO;
import com.ejercicioCovid19.ejercicioCovid19.dto.SintomaDTO;
import com.ejercicioCovid19.ejercicioCovid19.dto.SintomaGravedadDTO;
import com.ejercicioCovid19.ejercicioCovid19.repository.IRepositoryCovid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceCovid implements IServiceCovid{

    @Autowired
    IRepositoryCovid repository;

    @Override
    public List<SintomaDTO> mostrarSintomas() {
        return repository.getAllSintomas().stream()
                .map(sintoma -> new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre()))
                .toList();
    }

    @Override
    public SintomaGravedadDTO buscarSintoma(String name) {
        Optional<SintomaGravedadDTO> sintomaDTO = repository.getAllSintomas().stream()
                .filter(sintoma -> sintoma.getNombre().equals(name))
                .map(sintoma -> new SintomaGravedadDTO(sintoma.getNombre(), sintoma.getNivelDeGravedad()))
                .findFirst();
        return sintomaDTO.orElse(new SintomaGravedadDTO("Sintoma no encontrado", 0));
    }

    @Override
    public List<PersonaRiesgoDTO> mostrarPersonasDeRiesgo() {
        return repository.getAllPersonas().stream()
                .filter(persona -> persona.getEdad() > 60 &&
                        !persona.getSintomas().isEmpty())
                .map(persona -> new PersonaRiesgoDTO(persona.getNombre(), persona.getApellido()))
                .toList();
    }
}
