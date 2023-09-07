package com.startWars.startWars.service;

import com.startWars.startWars.dto.PersonajeDTO;
import com.startWars.startWars.mapper.PersonajeMapper;
import com.startWars.startWars.model.Personaje;
import com.startWars.startWars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{
    @Autowired
    PersonajeRepository personajeRepository;
    @Autowired
    PersonajeMapper personajeMapper;
    @Override
    public List<PersonajeDTO> buscarPorNombre(String nombre) {
        List<Personaje> personajesEncontrados = personajeRepository.buscarPorNombre(nombre);
        for (Personaje persona: personajesEncontrados
        ) {
            System.out.println(persona.getName());

        }
        return personajesEncontrados.stream().map(personaje -> personajeMapper.trasnformarDTO(personaje)).collect(Collectors.toList());
    }
}
