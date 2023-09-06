package com.example.covid19.Service;

import com.example.covid19.DTO.PersonaRiesgoDTO;
import com.example.covid19.Model.Persona;
import com.example.covid19.Repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonasService {
    private final PersonaRepository personasRepo;

    public PersonasService() {
        this.personasRepo = new PersonaRepository();
    }

    public List<PersonaRiesgoDTO> findRiskPersons() {
        List<Persona> personasRiesgo =  this.personasRepo.findAll().stream().filter(persona -> persona.getEdad() >= 60 && !persona.getSintomas().isEmpty()).toList();
        ArrayList<PersonaRiesgoDTO> personasRiesgoDTO = new ArrayList<>();
        personasRiesgo.forEach(persona -> {
            personasRiesgoDTO.add(
                    new PersonaRiesgoDTO(persona.getNombre(), persona.getEdad(), persona.getSintomas())
            );
        });

        return personasRiesgoDTO;
    }
}
