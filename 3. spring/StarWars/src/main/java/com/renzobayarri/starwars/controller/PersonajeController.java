package com.renzobayarri.starwars.controller;

import com.renzobayarri.starwars.dto.PersonajeDTO;
import com.renzobayarri.starwars.service.PersonajeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
@AllArgsConstructor
public class PersonajeController {

    private PersonajeService personajeService;

    @GetMapping("/")
    public ResponseEntity<List<PersonajeDTO>> getAll() {
        return ResponseEntity.ok(personajeService.getAll());
    }

    @GetMapping(value = "",params = "name")
    public ResponseEntity<List<PersonajeDTO>> getByName(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(personajeService.getByName(name));
    }
}
