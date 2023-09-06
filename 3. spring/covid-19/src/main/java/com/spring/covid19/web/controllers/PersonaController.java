package com.spring.covid19.web.controllers;

import com.spring.covid19.services.PersonaService;
import com.spring.covid19.web.dto.PersonaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persons")
public class PersonaController {
    private final PersonaService personaService;
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> getRiskyPersons() {
        List<PersonaDTO> personasConRiesgo;
        personasConRiesgo = personaService.findRiskPersons().stream().map(
                persona -> {
                    String name = persona.getNombre();
                    String apellido = persona.getApellido();
                    String riesgoAsociado = persona.getSintoma().getNombre();
                    return new PersonaDTO(name, apellido, riesgoAsociado);
                }
        ).collect(Collectors.toList());
        return personasConRiesgo;
    }
}
