package com.example.calcularedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RequestMapping("/")
@RestController
public class CalcularEdadController {
    @GetMapping("{day}/{month}/{year}")
    public int obtenerFecha(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate fechaDeEntrada = LocalDate.of(year, month, day);
        Period periodo = Period.between(fechaDeEntrada, LocalDate.now());
        return periodo.getYears();
    }
}
