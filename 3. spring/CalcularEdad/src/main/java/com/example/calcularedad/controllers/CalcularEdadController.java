package com.example.calcularedad.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalcularEdadController {

    @GetMapping("/{day}/{month}/{year}")
    public int getAge(
            @PathVariable int year,
            @PathVariable int day,
            @PathVariable int month) {
        LocalDate birthday = null;
        try {
            birthday = LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new RuntimeException("Fecha no válida");
        }
        LocalDate now = LocalDate.now();
        return Period.between(birthday, now).getYears();
    }
}
