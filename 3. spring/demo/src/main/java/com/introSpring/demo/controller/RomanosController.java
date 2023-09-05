package com.introSpring.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numeros_romanos")
public class RomanosController {
    @GetMapping("/convertir/{numero}")
    public String demo(@PathVariable Integer numero){

        int[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] combinacionesRomanas = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder resultado = new StringBuilder();

        int i=0;

        if (numero > 3000) return "No puede ser mayor a 3 mil";

        while(numero > 0){
            if(numero >= numeros[i]){
                resultado.append(combinacionesRomanas[i]);
                numero -= numeros[i];
            }else {
                i++;
            }
        }



        return "Valor: "+resultado;
    }

    @GetMapping("/demo")//Se lo llama con /demo?texto=___
    public String demoParam(@RequestParam String texto){
        return "Demo: "+texto;
    }

}
