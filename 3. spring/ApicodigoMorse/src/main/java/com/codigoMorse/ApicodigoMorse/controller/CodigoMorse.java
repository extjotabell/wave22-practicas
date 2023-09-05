package com.codigoMorse.ApicodigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/codigoMorse")
public class CodigoMorse {

    @GetMapping("/{frase}")
    public String morseAEspanol(@PathVariable String frase){
        StringBuilder decodificador = new StringBuilder();

        String[] palabras = frase.split("   ");
        for (String palabra: palabras) {
            for (String letra: palabra.split(" ")) {
                decodificador.append(this.codificacion.get(letra));
            }
            decodificador.append(" ");
        }

        return decodificador.toString();
    }

    private Map<String, String> codificacion = new HashMap<String, String>() {
        {
            put(".-", "A");
            put("-...", "B");
            put("-.-.", "C");
            put("-..", "D");
            put(".", "E");
            put("..-.", "F");
            put("--.", "G");
            put("....", "H");
            put("..", "I");
            put(".---", "J");
            put("-.-", "K");
            put(".-..", "L");
            put("--", "M");
            put("-.", "N");
            put("---", "O");
            put(".--.", "P");
            put("--.-", "Q");
            put(".-.", "R");
            put("...", "S");
            put("-", "T");
            put("..-", "U");
            put("...-", "V");
            put(".--", "W");
            put("-..-", "X");
            put("-.--", "Y");
            put("--..", "Z");
            put(".----", "1");
            put("..---", "2");
            put("...--", "3");
            put("....-", "4");
            put(".....", "5");
            put("-....", "6");
            put("--...", "7");
            put("---..", "8");
            put("----.", "9");
            put("-----", "0");
            put("..--..","?");
            put(".-.-.-",".");
            put("-.-.--","!");
            put("--..--",",");
        }
    };
}