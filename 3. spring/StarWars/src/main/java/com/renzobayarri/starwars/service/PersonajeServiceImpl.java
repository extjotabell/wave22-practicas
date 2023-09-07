package com.renzobayarri.starwars.service;

import com.renzobayarri.starwars.dto.PersonajeDTO;
import com.renzobayarri.starwars.repository.PersonajeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonajeServiceImpl implements PersonajeService{

    private PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDTO> getAll() {
        ModelMapper mapper = new ModelMapper();
        return personajeRepository.getAll().stream()
                .map(p -> mapper.map(p, PersonajeDTO.class))
                .toList();
    }

    @Override
    public List<PersonajeDTO> getByName(String name) {
        ModelMapper mapper = new ModelMapper();
        return personajeRepository.getAll().stream()
                .filter(p->p.getName().contains(name))
                .map(p -> mapper.map(p, PersonajeDTO.class))
                .toList();
    }
}
