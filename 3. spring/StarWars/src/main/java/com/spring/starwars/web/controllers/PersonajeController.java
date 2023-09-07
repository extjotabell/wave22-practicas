package com.spring.starwars.web.controllers;

import com.spring.starwars.entities.Personaje;
import com.spring.starwars.services.IPersonajeService;
import com.spring.starwars.web.dto.PersonajeDTO;
import com.spring.starwars.web.mappers.PersonajeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonajeController {

    private final IPersonajeService personajeService;
    private final PersonajeMapper personajeMapper;

    @GetMapping("/{word}")
    public List<PersonajeDTO> getPersonajesByWord(@PathVariable String word) {
        List<PersonajeDTO> personajeDTOS = (personajeService.getPersonajesByWord(word)).stream().
                        map(personajeMapper::toDto).collect(Collectors.toList());
        return personajeDTOS;
    }
}
