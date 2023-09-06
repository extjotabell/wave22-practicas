package com.edadconsulta.springpracticascalcularedad.EdadCalculatorController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Calendar;

@RestController
public class EdadCalculatorController {

    @GetMapping("/ObtenerEdad/{day}/{month}/{year}")
    public int CalcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year){

        int edad = 0;

        Calendar fechaActual = Calendar.getInstance();

        int yearToday = fechaActual.get(Calendar.YEAR);

        int monthToday = fechaActual.get(Calendar.MONTH) + 1;

        int dayToday = fechaActual.get(Calendar.DAY_OF_MONTH);

        edad = yearToday - year;

        if (monthToday < month){
            edad--;
        } else if ((monthToday == month && dayToday < day)) {
            edad--;
        }

        return edad;
    }

}
