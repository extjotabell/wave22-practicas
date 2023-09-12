package com.covid.covid19.controller;

import com.covid.covid19.Service.IPersonaService;
import com.covid.covid19.dto.PersonaDto;
import com.covid.covid19.dto.SintomaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sintoma")
public class PersonaController {

    @Autowired
    IPersonaService service;
    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDto>> GetAllSintoma(){
        return ResponseEntity.ok(service.AllSintoma());
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDto> GetSintoma(@PathVariable String name){
        return ResponseEntity.ok(service.GetSintoma(name));
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDto>> GetPersona(){
        return ResponseEntity.ok(service.GetPersona());
    }
}
