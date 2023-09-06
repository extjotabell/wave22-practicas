package com.practicos.edadPersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calculadora(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Crear un objeto LocalDate para la fecha de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        // Calcular la diferencia de años, meses y días
        Period periodo = Period.between(fechaNacimiento, fechaActual);

        // Obtener la edad
        int edad = periodo.getYears();

        return edad;
    }
}
