package com.ejercicioCovid19.ejercicioCovid19.controller;

import com.ejercicioCovid19.ejercicioCovid19.dto.SintomaDTO;
import com.ejercicioCovid19.ejercicioCovid19.dto.SintomaGravedadDTO;
import com.ejercicioCovid19.ejercicioCovid19.service.IServiceCovid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    IServiceCovid service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> mostrarSintomas(){
        return new ResponseEntity<>(service.mostrarSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaGravedadDTO> buscarSintoma(@PathVariable String name){
        return new ResponseEntity<>(service.buscarSintoma(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> mostrarPersonasDeRiesgo(){
        return new ResponseEntity<>(service.mostrarPersonasDeRiesgo(),HttpStatus.OK);
    }
}
