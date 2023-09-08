package com.Meli.calculadoraDeEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class calculadoraController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calculadora(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        LocalDate fechaActual = LocalDate.now();


        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);


        Period periodo = Period.between(fechaNacimiento, fechaActual);

        int edad = periodo.getYears();

        return edad;
    }
}
