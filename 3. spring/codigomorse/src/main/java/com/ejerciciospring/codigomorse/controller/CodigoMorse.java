package com.ejerciciospring.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorse {

    @GetMapping("/decodificar/{frase}")
    public String decodificar(@PathVariable String frase){

        frase = frase.replace("%20", " ");
        // Divide el código Morse en palabras
        String[] palabrasMorse = frase.split("   "); // 3 espacios indican una nueva palabra
        StringBuilder decodificador = new StringBuilder();

        for (String palabra : palabrasMorse) {
            String[] letrasMorse = palabra.split(" "); // Espacios simples separan las letras
            for (String letraMorse : letrasMorse) {
                // Traduce cada letra Morse y agrega la traducción al resultado
                decodificador.append(morseToSpanish.getOrDefault(letraMorse, "?"));
            }
            // Agrega un espacio entre palabras en la traducción
            decodificador.append(" ");
        }

        return decodificador.toString().trim();
    }

    @GetMapping("/codificar/{frase}")
    public String codificar(@PathVariable String frase){

        // Divide el código Morse en palabras
        String[] palabrasSpanish = frase.split("   "); // 3 espacios indican una nueva palabra
        StringBuilder codificador = new StringBuilder();

        for (String palabra : palabrasSpanish) {
            for (char letraSpanish : palabra.toUpperCase().toCharArray()) {
                // Traduce cada letra Morse y agrega la traducción al resultado
                String letra = String.valueOf(letraSpanish);
                codificador.append(spanishToMorse.getOrDefault(letra, "?")).append(" ");
            }
            // Agrega tres espacios entre palabras en la traducción de código Morse
            codificador.append("   ");
        }

        return codificador.toString().trim();
    }
    private Map<String, String> spanishToMorse = new HashMap<String, String>() {
        {
            put("A",".-");
            put("B","-...");
            put("C","-.-.");
            put("D","-..");
            put("E",".");
            put("F","..-.");
            put("G","--.");
            put("H","....");
            put("I","..");
            put("J",".---");
            put("K","-.-");
            put("L",".-..");
            put("M","--");
            put("N","-.");
            put("O","---");
            put("P",".--.");
            put("Q","--.-");
            put("R",".-.");
            put("S","...");
            put("T","-");
            put("U","..-");
            put("V","...-");
            put("W",".--");
            put("X","-..-");
            put("Y","-.--");
            put("Z","--..");
            put("0","-----");
            put("1",".----");
            put("2","..---");
            put("3","...--");
            put("4","....-");
            put("5",".....");
            put("6","-....");
            put("7","--...");
            put("8","---..");
            put("9","----.");
            put(" "," ");
        }
    };

    private Map<String, String> morseToSpanish = new HashMap<String, String>() {
        {
        put(".-","A");
        put("-...","B");
        put("-.-.","C");
        put("-..","D");
        put(".","E");
        put("..-.","F");
        put("--.","G");
        put("....","H");
        put("..","I");
        put(".---","J");
        put("-.-","K");
        put(".-..","L");
        put("--","M");
        put("-.","N");
        put("---","O");
        put(".--.","P");
        put("--.-","Q");
        put(".-.","R");
        put("...","S");
        put("-","T");
        put("..-","U");
        put("...-","V");
        put(".--","W");
        put("-..-","X");
        put("-.--","Y");
        put("--..","Z");
        put("-----","0");
        put(".----","1");
        put("..---","2");
        put("...--","3");
        put("....-","4");
        put(".....","5");
        put("-....","6");
        put("--...","7");
        put("---..","8");
        put("----.","9");
        }
    };
}
