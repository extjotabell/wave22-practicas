package com.calcEdades.edad.controllers;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@RestController
public class CalculadoraDeEdad {
    @GetMapping ("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return calculaEdad(dia, mes, anio);
    }

    private int calculaEdad(int dia, int mes, int anio) {
        LocalDate nacimiento = LocalDate.of(anio, mes, dia);
        LocalDate hoy = LocalDate.now();
        return Period.between(nacimiento, hoy).getYears();
    }

}
