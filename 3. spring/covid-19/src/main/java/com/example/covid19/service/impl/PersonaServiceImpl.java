package com.example.covid19.service.impl;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import com.example.covid19.repository.PersonaRepository;
import com.example.covid19.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    PersonaRepository repository;
    @Override
    public List<Persona> getAll() {
        return repository.getAll();
    }

    public List<PersonaDTO> getPersonasRiesgo(){
        List<Persona> personas = getAll();
        List<PersonaDTO> personasMayoresConSintomas = personas.stream()
                .filter(persona -> persona.getEdad() >= 60)
                .filter(persona -> !persona.getSintomas().isEmpty())
                .map(persona -> new PersonaDTO(
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getEdad(),
                        persona.getSintomas()
                ))
                .collect(Collectors.toList());
        return personasMayoresConSintomas;
    }
}
