package com.mercadolibre.ejerciciocodigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CodigoMorseController {

    @GetMapping("/codigomorse")
    public String convertirMorse(@RequestParam String texto) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, String> codigoMorse = construirCodigoMorse();
        char[] charTexto = texto.toCharArray();
        for (char c : charTexto) {
            if (codigoMorse.get(c) != null) {
                sb.append(codigoMorse.get(c));
                if (c != ' ')
                    sb.append(" ");
            }
        }
        return sb.toString();
    }

    private HashMap<Character, String> construirCodigoMorse() {
        HashMap<Character, String> codigoMorse = new HashMap<>();
        codigoMorse.put('a', ".-");
        codigoMorse.put('b', "-...");
        codigoMorse.put('c', "-.-.");
        codigoMorse.put('d', "-..");
        codigoMorse.put('e', ".");
        codigoMorse.put('f', "..-.");
        codigoMorse.put('g', "--.");
        codigoMorse.put('h', "....");
        codigoMorse.put('i', "..");
        codigoMorse.put('j', ".---");
        codigoMorse.put('k', "-.-");
        codigoMorse.put('l', ".-..");
        codigoMorse.put('m', "--");
        codigoMorse.put('n', "-.");
        codigoMorse.put('o', "----");
        codigoMorse.put('p', ".--.");
        codigoMorse.put('q', "--.-");
        codigoMorse.put('r', ".-.");
        codigoMorse.put('s', "...");
        codigoMorse.put('t', ".-");
        codigoMorse.put('u', "..-");
        codigoMorse.put('v', "...-");
        codigoMorse.put('w', ".--");
        codigoMorse.put('x', "-..-");
        codigoMorse.put('y', "-.--");
        codigoMorse.put('z', "--..");
        codigoMorse.put('0', ".-");
        codigoMorse.put('1', ".----");
        codigoMorse.put('2', "..---");
        codigoMorse.put('3', "...--");
        codigoMorse.put('4', "....-");
        codigoMorse.put('5', ".....");
        codigoMorse.put('6', "-....");
        codigoMorse.put('7', "--...");
        codigoMorse.put('8', "---..");
        codigoMorse.put('9', "----.");
        codigoMorse.put('?', "..--..");
        codigoMorse.put('!', "-.-.--");
        codigoMorse.put('.', ".-.-.-");
        codigoMorse.put(',', "--..--");
        codigoMorse.put(' ', "   ");
        return codigoMorse;
    }
}
