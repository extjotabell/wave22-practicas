package com.example.starwars.service.impl;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.model.Personaje;
import com.example.starwars.repository.impl.PersonajeRepository;
import com.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {
    @Autowired
    PersonajeRepository repository;
    @Override
    public List<Personaje> findAll() {
        return repository.getAll();
    }
    public List<PersonajeDTO> findByName(String name){
        return findAll()
                .stream()
                .filter(p -> p.getName().contains(name))
                .map(personaje -> new PersonajeDTO(
                        personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies())
                ).collect(Collectors.toList());
    }
}
