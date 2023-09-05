package com.introSpring.demo.controller;

import com.introSpring.demo.util.MorseNormalConversor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {

    MorseNormalConversor conversor = new MorseNormalConversor();

    @GetMapping("morse_normal/")
    public String convertirATexto(@RequestParam String morse){
        StringBuilder resultado = new StringBuilder();
        String[] palabras = morse.split(" {3}");


        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for (String letra : letras) {
                resultado.append(conversor.convertirMorse(letra));
            }
            resultado.append(" ");
        }
        resultado.setLength(resultado.length() - 1);
        return resultado.toString();
    }

    @GetMapping("normal_morse/")
    public String convertirAMorse(@RequestParam String texto){
        StringBuilder resultado = new StringBuilder();
        String[] palabras = texto.split(" ");


        for(int i=0; i < palabras.length; i++){
            String[] letras = palabras[i].split("");
            for(String letra : letras){
                resultado.append(conversor.convertirNormal(letra.toLowerCase()) + " ");
            }
            resultado.append("  ");
        }
        //Saco los espacios del final
        resultado.setLength(resultado.length()-3);
        return resultado.toString();
    }
}
