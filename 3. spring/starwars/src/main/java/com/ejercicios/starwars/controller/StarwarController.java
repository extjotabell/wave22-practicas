package com.ejercicios.starwars.controller;

import com.ejercicios.starwars.dto.PersonajeDTO;
import com.ejercicios.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarwarController {

    @Autowired
    IPersonajeService service;

    @GetMapping("/")
    public ResponseEntity<?> getAllPersonajes(){
        List<PersonajeDTO> personajeDTOList = service.getAll();
        return new ResponseEntity<>(personajeDTOList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(service.findByName(name),HttpStatus.OK);
    }
}
