package com.codigoMorse.codigoMorse.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseConvertor {

    private String traductor(String codigo){
        HashMap<String, String> morseToChar = new HashMap<>();
        morseToChar.put(".-", "A");
        morseToChar.put("-...", "B");
        morseToChar.put("-.-.", "C");
        morseToChar.put("-..", "D");
        morseToChar.put(".", "E");
        morseToChar.put("..-.", "F");
        morseToChar.put("--.", "G");
        morseToChar.put("....", "H");
        morseToChar.put("..", "I");
        morseToChar.put(".---", "J");
        morseToChar.put("-.-", "K");
        morseToChar.put(".-..", "L");
        morseToChar.put("--", "M");
        morseToChar.put("-.", "N");
        morseToChar.put("---", "O");
        morseToChar.put(".--.", "P");
        morseToChar.put("--.-", "Q");
        morseToChar.put(".-.", "R");
        morseToChar.put("...", "S");
        morseToChar.put("-", "T");
        morseToChar.put("..-", "U");
        morseToChar.put("...-", "V");
        morseToChar.put(".--", "W");
        morseToChar.put("-..-", "X");
        morseToChar.put("-.--", "Y");
        morseToChar.put("--..", "Z");
        morseToChar.put("-----", "0");
        morseToChar.put(".----", "1");
        morseToChar.put("..---", "2");
        morseToChar.put("...--", "3");
        morseToChar.put("....-", "4");
        morseToChar.put(".....", "5");
        morseToChar.put("-....", "6");
        morseToChar.put("--...", "7");
        morseToChar.put("---..", "8");
        morseToChar.put("----.", "9");


        // Divide el código Morse en palabras
        String[] words = codigo.split("   ");

        // Convierte el código Morse a palabras
        StringBuilder text = new StringBuilder();
        for (String word : words) {
            String[] characters = word.split(" ");
            StringBuilder wordText = new StringBuilder();
            for (String character : characters) {
                if (morseToChar.containsKey(character)) {
                    wordText.append(morseToChar.get(character));
                } else {
                    // Carácter no reconocido, puedes manejarlo como desees
                }
            }
            text.append(wordText).append(" ");
        }

        return text.toString();
    }

    @GetMapping("/traductor")
    public String convertor(@RequestParam String codigo){
        return traductor(codigo);
    }

}
