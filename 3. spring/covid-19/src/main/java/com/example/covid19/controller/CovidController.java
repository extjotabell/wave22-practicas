package com.example.covid19.controller;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.model.Sintoma;
import com.example.covid19.service.impl.PersonaServiceImpl;
import com.example.covid19.service.impl.SintomaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    SintomaServiceImpl sintomaService;
    @Autowired
    PersonaServiceImpl personaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptoms(){
        return ResponseEntity.ok(sintomaService.getAll());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> findByName(@PathVariable String name){
        return ResponseEntity.ok(sintomaService.findByName(name));
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findRiskPerson(){
        return ResponseEntity.ok(personaService.getPersonasRiesgo());
    }




}
