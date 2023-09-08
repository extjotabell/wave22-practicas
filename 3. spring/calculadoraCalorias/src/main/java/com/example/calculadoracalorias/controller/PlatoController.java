package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.service.IPlatoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    @Autowired
    IPlatoService servicio;

    @GetMapping("/platoCaloria/{name}")
    ResponseEntity<?> getCaloriasByName(@PathVariable String name){
        return new ResponseEntity<>(servicio.getCaloriasByName(name), HttpStatus.OK);
    }

    @GetMapping("/foodConMasCaloria/{name}")
    ResponseEntity<?> getFoodConMayorCalorias(@PathVariable String name){
        return new ResponseEntity<>(servicio.getFoodConMayorCalorias(name), HttpStatus.OK);
    }
}
