package com.calculadoradeedad.EP1DtoVIVOCalculadoraDeEdad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age-calculator")
public class AgeCalculatorController {
    @GetMapping("/{day}/{month}/{year}")
    public int calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        if (birthdate.isAfter(currentDate))
            return 0;

        return Period.between(birthdate, currentDate).getYears();
    }
}
