package com.mercadolibre.ejerciciopersonajes.controller;

import com.mercadolibre.ejerciciopersonajes.dto.PersonajeDTO;
import com.mercadolibre.ejerciciopersonajes.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonajeController {

    @Autowired
    private IPersonajeService personajeService;

    @GetMapping("/buscarPersonajes")
    public ResponseEntity<List<PersonajeDTO>> getAllPersonajes() {
        return ResponseEntity.ok(personajeService.getAllPersonajes());
    }

    @GetMapping("/buscarPersonajes/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajesByName(@PathVariable String name) {
        return ResponseEntity.ok(personajeService.getAllPersonajesByName(name));
    }
}
