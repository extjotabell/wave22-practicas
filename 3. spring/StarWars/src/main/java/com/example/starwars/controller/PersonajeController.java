package com.example.starwars.controller;

import com.example.starwars.dtos.PersonajeDTO;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeService service;

    @GetMapping("/personaje/{name}")
    ResponseEntity<?> getPersonajeByName(@PathVariable String name){
        List<PersonajeDTO> listaPersonajes = service.getPersonajeByName(name);
        return new ResponseEntity<>(listaPersonajes, HttpStatus.OK);
    }
}
