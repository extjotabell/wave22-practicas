package com.ejercicioStarWars.ejercicioStarWars.controller;

import com.ejercicioStarWars.ejercicioStarWars.dto.PersonajeDTO;
import com.ejercicioStarWars.ejercicioStarWars.service.IServiceStarWars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    IServiceStarWars service;

    @GetMapping("/findCharacter")
    public ResponseEntity<List<PersonajeDTO>> searchPersonaje(@RequestParam String name){
        return new ResponseEntity<>(service.searchPersonajes(name), HttpStatus.OK);
    }
}
