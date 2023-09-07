package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.repository.PersonajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;


    public PersonajeDTO findPersonajeByName(String name) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this.personajeRepository.findByName(name), PersonajeDTO.class);
    }
}
