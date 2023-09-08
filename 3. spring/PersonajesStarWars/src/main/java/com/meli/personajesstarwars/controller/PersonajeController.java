package com.meli.personajesstarwars.controller;

import com.meli.personajesstarwars.service.IPersonajeService;
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
    IPersonajeService personajeService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return  new ResponseEntity<>(personajeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name){
        return  new ResponseEntity<>(personajeService.findByName(name), HttpStatus.OK);
    }
}
