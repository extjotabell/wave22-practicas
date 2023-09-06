package com.practicos.Covid19.service;
import com.practicos.Covid19.dto.PersonaDTO;
import com.practicos.Covid19.model.Persona;
import com.practicos.Covid19.repository.impl.PersonaImpl;

import java.util.ArrayList;
import java.util.List;

public class PersonaService {
    private final PersonaImpl personasRepo;

    public PersonaService() {
        this.personasRepo = new PersonaImpl();
    }

    public List<PersonaDTO> findRiskPersons() {
        List<Persona> personasRiesgo =  this.personasRepo.findAll().stream().filter(persona -> persona.getEdad() >= 60 && !persona.getSintomas().isEmpty()).toList();
        ArrayList<PersonaDTO> personasRiesgoDTO = new ArrayList<>();
        personasRiesgo.forEach(persona -> {
            personasRiesgoDTO.add(
                    new PersonaDTO(persona.getNombre(), persona.getEdad(), persona.getSintomas())
            );
        });

        return personasRiesgoDTO;
    }
}
