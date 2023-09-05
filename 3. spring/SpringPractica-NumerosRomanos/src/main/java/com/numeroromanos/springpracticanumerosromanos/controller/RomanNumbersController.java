package com.numeroromanos.springpracticanumerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RomanNumbersController {

    private static final Map<Integer, String> diccionario = new HashMap<>();

    static {
        diccionario.put(1, "I");
        diccionario.put(4, "IV");
        diccionario.put(5, "V");
        diccionario.put(9, "IX");
        diccionario.put(10, "X");
        diccionario.put(40, "XL");
        diccionario.put(50, "L");
        diccionario.put(90, "XC");
        diccionario.put(100, "C");
        diccionario.put(400, "CD");
        diccionario.put(500, "D");
        diccionario.put(900, "CM");
        diccionario.put(1000, "M");
    }

    @GetMapping("/{numero}")
    public String decimalARomano(@PathVariable int numero) {
        if (numero <= 0 || numero > 3999) {
            return "El número debe estar en el rango de 1 a 3999.";
        }

        StringBuilder resultado = new StringBuilder();

        while (numero > 0) {
            int maxValor = 0;
            String maxRomano = "";

            for (Map.Entry<Integer, String> entry : diccionario.entrySet()) {
                if (entry.getKey() <= numero && entry.getKey() > maxValor) {
                    maxValor = entry.getKey();
                    maxRomano = entry.getValue();
                }
            }

            resultado.append(maxRomano);
            numero -= maxValor;
        }

        return resultado.toString();
    }
}
