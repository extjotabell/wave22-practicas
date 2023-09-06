package com.calculadoraEdad.calculadoraEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalcularEdad {

    @GetMapping("/edad/{day}/{month}/{year}")
    public int calculaedad(@PathVariable int day, @PathVariable int month, @PathVariable int year){

        LocalDate fecha = LocalDate.of(year,month,day);
        int edad = Period.between(fecha,LocalDate.now()).getYears();
        return edad;
    }
}
