package com.spring.starwars.services.impl;

import com.spring.starwars.entities.Personaje;
import com.spring.starwars.repositories.IPersonajeRepository;
import com.spring.starwars.services.IPersonajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements IPersonajeService {

    private final IPersonajeRepository personajeRepository;
    @Override
    public List<Personaje> getPersonajesByWord(String word) {
        return personajeRepository.findPersonajesByWord(word);
    }
}
