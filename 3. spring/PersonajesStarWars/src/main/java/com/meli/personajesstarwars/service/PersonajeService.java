package com.meli.personajesstarwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.personajesstarwars.dto.PersonajeDTO;
import com.meli.personajesstarwars.model.Personaje;
import com.meli.personajesstarwars.repository.IPersonajeRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    IPersonajeRepository personajeRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public List<PersonajeDTO> findAll() {

        List<Personaje> personajeList = personajeRepository.findAll();
        List<PersonajeDTO> personajeDTOS = new ArrayList<>();
        for (Personaje p: personajeList) {
            personajeDTOS.add(mapper.convertValue(p, PersonajeDTO.class));
        }
        return personajeDTOS;
    }

    @Override
    public List<PersonajeDTO> findByName(String name) {

        List<Personaje> personajeList = personajeRepository.findByName(name);
        List<PersonajeDTO> personajeDTOS = new ArrayList<>();
        for (Personaje p: personajeList) {
            personajeDTOS.add(mapper.convertValue(p, PersonajeDTO.class));
        }
        return personajeDTOS;
    }
}
