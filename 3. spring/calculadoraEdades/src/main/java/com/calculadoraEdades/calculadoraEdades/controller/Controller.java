package com.calculadoraEdades.calculadoraEdades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(birthDate, currentDate);

        return periodo.getYears();
    }
}
