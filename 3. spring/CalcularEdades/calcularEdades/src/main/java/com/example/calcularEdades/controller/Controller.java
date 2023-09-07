package com.example.calcularEdades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {

    @GetMapping("/{day}/{month}/{year}")
    public int getAge(@PathVariable int day,
                  @PathVariable int month,
                  @PathVariable int year) throws Exception {
        LocalDate birthday = null;
        try{
            birthday = LocalDate.of(year,month,day);
        } catch(Exception e){
            System.out.println("La fecha ingresada no es valida / " + e.getMessage());
        }
        LocalDate now = LocalDate.now();
        return Period.between(birthday, now).getYears();

    }

}
