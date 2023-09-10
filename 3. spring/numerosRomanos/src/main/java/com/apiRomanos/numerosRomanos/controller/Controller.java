package com.apiRomanos.numerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/convert/{number}")
    public String convertNumber(@PathVariable int number){
        StringBuilder result = new StringBuilder();

        final Map<Integer, String> ROMAN_NUMBERS_MAP = new LinkedHashMap<>();
        ROMAN_NUMBERS_MAP.put(1000, "M");
        ROMAN_NUMBERS_MAP.put(900, "CM");
        ROMAN_NUMBERS_MAP.put(500, "D");
        ROMAN_NUMBERS_MAP.put(400, "CD");
        ROMAN_NUMBERS_MAP.put(100, "C");
        ROMAN_NUMBERS_MAP.put(90, "XC");
        ROMAN_NUMBERS_MAP.put(50, "L");
        ROMAN_NUMBERS_MAP.put(40, "XL");
        ROMAN_NUMBERS_MAP.put(10, "X");
        ROMAN_NUMBERS_MAP.put(9, "IX");
        ROMAN_NUMBERS_MAP.put(5, "V");
        ROMAN_NUMBERS_MAP.put(4, "IV");
        ROMAN_NUMBERS_MAP.put(1, "I");

        for(Map.Entry<Integer, String> entrada : ROMAN_NUMBERS_MAP.entrySet()){
            int decimalValue = entrada.getKey();
            String romanLetter = entrada.getValue();

            while(number >= decimalValue){
                result.append(romanLetter);
                number -= decimalValue;
            }
        }
        return  result.toString();
    }

}
