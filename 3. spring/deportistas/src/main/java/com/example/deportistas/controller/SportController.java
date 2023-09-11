package com.example.deportistas.controller;

import com.example.deportistas.dto.DeportistaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import com.example.deportistas.service.DeporteService;
import com.example.deportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    @Autowired
    DeporteService deporteService;
    @Autowired
    PersonaService personaService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllSports(){
        return ResponseEntity.ok(deporteService.getAll());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> getSportByName(@PathVariable String name){
        return ResponseEntity.ok(deporteService.getByName(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getAllSportPeople(){
        return ResponseEntity.ok(personaService.getAllDeportistas());
    }
}
