package com.example.starwars.controller;

import com.example.starwars.DTO.PersonajeDTO;
import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeService service;

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/personajes/")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@RequestParam String name){
        List<PersonajeDTO> listaPersonajes = service.getPersonajes(name);
        return listaPersonajes.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                :new ResponseEntity<>(listaPersonajes, HttpStatus.OK);
    }

}
