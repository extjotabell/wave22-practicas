package com.renzobayarri.edadpersona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaController {

    @GetMapping("/{day}/{month}/{year}")
    public int getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year) throws Exception {
        LocalDate birthday = null;
        LocalDate now = LocalDate.now();
        try{
            birthday = LocalDate.of(year, month, day);
        }catch (Exception e){
            throw new Exception("La fecha indicada es inválida");
        }
        return Period.between(birthday, now).getYears();
    }
}
