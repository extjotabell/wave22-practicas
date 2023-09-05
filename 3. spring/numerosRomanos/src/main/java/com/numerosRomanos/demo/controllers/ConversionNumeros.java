package com.numerosRomanos.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionNumeros {

    @GetMapping("/{num}")
    public String conversion(@PathVariable Integer num){
        int numeros[] = {1000,500,100,50,13,10,7,5,4,3,2,1};
        String numerosRomanos[] = {"M","D","C","L","XIII","X","VII","V","IV","III","II","I"};
        StringBuilder numeroAdevolver = new StringBuilder();

        for (int i = 0; i < numeros.length; i++){
            while (num >= numeros[i]){
                numeroAdevolver.append(numerosRomanos[i]);
                num -= numeros[i];
            }
        }


        return numeroAdevolver.toString();
    }
}
