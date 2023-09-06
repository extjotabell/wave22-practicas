package com.example.ejercicioedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {
    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer getEdad(@PathVariable Integer dia,@PathVariable Integer mes, @PathVariable Integer anio){
        LocalDate fecha = LocalDate.of(anio,mes,dia);
        return Period.between(fecha, LocalDate.now()).getYears();
    }
}
