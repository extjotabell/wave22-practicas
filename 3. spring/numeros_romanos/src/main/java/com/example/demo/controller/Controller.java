package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private String nombre;
    private static final int[] valoresDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] simbolosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    // Convierte un número decimal a uno romano
    @GetMapping("/convertir")
    private String saludar(@RequestParam double numero){
        return decimalARomano(numero);
    }

    protected String decimalARomano(double numero){
        StringBuilder resultado = new StringBuilder();

        // Asegurarse de que el número esté dentro del rango (1-3999)
        if (numero < 1 || numero > 3999) {
            return "Número fuera de rango";
        }

        // Iterar a través de los valores decimales y los símbolos romanos
        for (int i = 0; i < valoresDecimales.length; i++) {
            while (numero >= valoresDecimales[i]) {
                resultado.append(simbolosRomanos[i]);
                numero -= valoresDecimales[i];
            }
        }

        return resultado.toString();
    }

}
