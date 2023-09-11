package com.traductorMorse.traductorMorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class traductor {
    char[] letter = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', ' ' };
    // Morse code by indexing
    String[] code
            = { ".-",   "-...", "-.-.", "-..",  ".",
            "..-.", "--.",  "....", "..",   ".---",
            "-.-",  ".-..", "--",   "-.",   "---",
            ".--.", "--.-", ".-.",  "...",  "-",
            "..-",  "...-", ".--",  "-..-", "-.--",
            "--..", "   " };

    @GetMapping("/morseALetras")
    public String morseALetras(@RequestParam String morse){
        return morseToLetters(morse);
    }

    @GetMapping("/letrasAMorse")
    public String letrasAMorse(@RequestParam String letras){
        return lettersToMorse(letras);
    }

    private String lettersToMorse(String lettersString){
        String[] arrayLetras = lettersString.split("");
        StringBuilder result = new StringBuilder();
        for (String s : arrayLetras) {
            int cont = 0;
            while (cont < letter.length && String.valueOf(letter[cont]).compareTo(s) != 0) {
                cont++;
            }
            if(cont >= letter.length){
                throw new IllegalArgumentException("No se encontró el símbolo " + s);
            }
        result.append(code[cont] + " ");

        }
        return result.toString().replace("     ", "   ");
    }

    private String morseToLetters(String morseString){
        String[] arrayMorse = morseString.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : arrayMorse) {
            int cont = 0;
            while (cont < code.length && code[cont].compareTo(s) != 0) {
                cont++;
            }
            if(cont >= code.length){
                throw new IllegalArgumentException("No se encontró el símbolo " + s);
            }
            result.append(String.valueOf(letter[cont]));
        }
        return result.toString();
        }

    }
