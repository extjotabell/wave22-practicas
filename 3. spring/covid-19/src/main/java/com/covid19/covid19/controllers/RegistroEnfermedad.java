package com.covid19.covid19.controllers;

import com.covid19.covid19.DTO.PersonaDTO;
import com.covid19.covid19.entidades.Sintoma;
import com.covid19.covid19.repositorios.RepositorioDTO;
import com.covid19.covid19.repositorios.RepositorioSintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegistroEnfermedad {

    @GetMapping("/findSymptom")
    ResponseEntity<String> mostrarSintomas(){
        if(RepositorioSintoma.sintomas.isEmpty()){
            return ResponseEntity.badRequest().body("Error: no hay sintomas cargados");
        }

        return ResponseEntity.status(200).body("Sintomas: " + RepositorioSintoma.sintomas);
    }

    @GetMapping("findSymptom/{name}")
    ResponseEntity<String> buscarSintoma(@PathVariable String name){
        boolean sintoma = RepositorioSintoma.buscarSintoma(name);
        if(sintoma == false){
            return ResponseEntity.badRequest().body("No existe sintoma con ese nombre");
        }
        return ResponseEntity.status(200).body("Ese sintoma puede ser de Covid-19");
    }

    @GetMapping("/findRiskPerson")
    ResponseEntity<String> personasRiesgo(){
        List<PersonaDTO> personasRiesgo = RepositorioDTO.buscarPersonaRiesgo();
        if(personasRiesgo.isEmpty()){
            return ResponseEntity.badRequest().body("No hay personas de riesgo");
        }

        return ResponseEntity.status(200).body("Personas de riego: " + personasRiesgo);
    }

}
