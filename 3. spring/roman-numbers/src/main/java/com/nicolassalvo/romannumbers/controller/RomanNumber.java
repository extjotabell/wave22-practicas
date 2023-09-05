package com.nicolassalvo.romannumbers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RomanNumber {
    @GetMapping("/convert")
    public String getRomanNumber(@RequestParam(defaultValue = "0") int number) {
        return convertToRomanNumber(number);
    }

    private String convertToRomanNumber(int number) {
        if (number == 0) {
            return "No se encontró número a convertir";
        }

        // copy of solution to convert to roman number
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }
}
