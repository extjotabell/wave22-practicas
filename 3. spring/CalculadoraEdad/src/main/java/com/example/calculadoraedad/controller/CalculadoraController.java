package com.example.calculadoraedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("calcularEdad")
public class CalculadoraController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        LocalDate date = LocalDate.of(anio, mes, dia);
        LocalDate actualDate = LocalDate.now();
        return Period.between(date, actualDate).getYears();
    }

}
