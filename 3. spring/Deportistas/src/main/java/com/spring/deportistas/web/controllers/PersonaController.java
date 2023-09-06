package com.spring.deportistas.web.controllers;

import com.spring.deportistas.services.PersonaService;
import com.spring.deportistas.web.dto.PersonaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonaController {
    private final PersonaService personaService;
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaDTO> getSportsPersons() {
        return personaService.findAllSportPeople();
    }

}
