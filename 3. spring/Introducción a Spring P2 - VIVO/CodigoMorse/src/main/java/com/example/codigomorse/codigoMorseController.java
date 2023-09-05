package com.example.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class codigoMorseController {

    private static final String[] espanol = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?", "!", ":", "@", "=", "-", "+", "\"", "/", "&",
            "'", "(", ")"
    };

    private static final String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--..", "-.-.--", "---...", ".--.-.",
            "-...-", "-....-", ".-.-.", ".-..-.", "-..-.", ".-...", ".----.",
            "-.--.", "-.--.-"
    };

    private static final Map<String, String> ESP_TO_MORSE = new HashMap<>();
    private static final Map<String, String> MORSE_TO_ESP = new HashMap<>();

    static {
        for (int i = 0; i < espanol.length; i++) {
            ESP_TO_MORSE.put(espanol[i], morse[i]);
            MORSE_TO_ESP.put(morse[i], espanol[i]);
        }
    }

    @GetMapping("/morseToEsp")
    public String obtenerTraduccionEsp(@RequestParam String morse) {

        String[] palabras = morse.split("   ");
        StringBuilder palabraFormada = new StringBuilder();
        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for (String letra : letras) {
                palabraFormada.append(MORSE_TO_ESP.get(letra));
            }

            palabraFormada.append(" ");
        }
        return palabraFormada.substring(0, palabraFormada.length() - 1);
    }

    @GetMapping("/espToMorse")
    public String obtenerTraduccionMorse(@RequestParam String oracion) {

        String[] palabras = oracion.split(" ");
        StringBuilder palabraFormada = new StringBuilder();
        for (String palabra : palabras) {
            String[] letras = palabra.split("");
            for (String letra : letras) {
                palabraFormada.append(ESP_TO_MORSE.get(letra));
                palabraFormada.append(" ");
            }

            palabraFormada.append("  ");
        }
        return palabraFormada.substring(0, palabraFormada.length() - 3);
    }


}
