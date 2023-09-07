package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public ResponseEntity<PersonajeDTO> getPersonajeByName(@RequestParam String name){
        return new ResponseEntity<PersonajeDTO>(this.personajeService.findPersonajeByName(name), HttpStatus.OK);
    }
}
