package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.StarWarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/starwars")
public class StarWarsController {

    private final StarWarsService starWarsService;

    @GetMapping("/persons")
    public ResponseEntity<List<PersonajeDTO>> getAllByName(@RequestParam(required = false) String name){
        return ResponseEntity.ok(starWarsService.getAllByName(name));
    }
}
