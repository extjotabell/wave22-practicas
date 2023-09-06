package com.example.ejerciciocalculadoraedad;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculadoraController {

    @GetMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        int anios = Period.between(fecha, LocalDate.now()).getYears();
        return anios;
    }
}
