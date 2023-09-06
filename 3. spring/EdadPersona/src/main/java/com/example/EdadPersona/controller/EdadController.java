package com.example.EdadPersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {
    @GetMapping("fecha/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        LocalDate nacimiento = LocalDate.of(anio, mes, dia);
        LocalDate hoy = LocalDate.now();
        Period dif = Period.between(nacimiento, hoy);

        return dif.getYears();
    }
}
