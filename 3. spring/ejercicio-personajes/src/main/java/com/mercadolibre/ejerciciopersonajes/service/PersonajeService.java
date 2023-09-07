package com.mercadolibre.ejerciciopersonajes.service;

import com.mercadolibre.ejerciciopersonajes.dto.PersonajeDTO;
import com.mercadolibre.ejerciciopersonajes.model.Personaje;
import com.mercadolibre.ejerciciopersonajes.repository.IPersonajeRepository;
import com.mercadolibre.ejerciciopersonajes.repository.PersonajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService implements IPersonajeService {

    @Autowired
    private IPersonajeRepository personajeRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<PersonajeDTO> getAllPersonajesByName(String name) {
        List<Personaje> personajes = personajeRepository.getAllPersonajesByName(name);
        List<PersonajeDTO> personajesDTO = personajes.stream().map(p -> mapper.map(p, PersonajeDTO.class)).toList();
        return personajesDTO;
    }

    @Override
    public List<PersonajeDTO> getAllPersonajes() {
        List<Personaje> personajes = personajeRepository.getAllPersonajes();
        List<PersonajeDTO> personajesDTO = personajes.stream().map(p -> mapper.map(p, PersonajeDTO.class)).toList();
        return personajesDTO;
    }

}
