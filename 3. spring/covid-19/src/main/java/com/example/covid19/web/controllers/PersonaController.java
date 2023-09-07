package com.example.covid19.web.controllers;

import com.example.covid19.services.PersonaService;
import com.example.covid19.web.dto.PersonaDTO;
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

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> getFindRiskPerson() {
        return personaService.findRiskPerson();
    }

}