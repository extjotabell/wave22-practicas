package com.ejercicio.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    @GetMapping("romano/{num}")
    public String toRomao(@PathVariable Integer num){
        StringBuilder resultado = new StringBuilder();
        if (num < 1) {
            return "El numero debe ser mayor a 0";
        }else {
            String[] simbolos = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
            int[] valores = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

            for (int i = simbolos.length - 1; i >= 0; i--) {
                while (num >= valores[i]) {
                    resultado.append(simbolos[i]);
                    num -= valores[i];
                }
            }
        }

        return resultado.toString();


    }
}
