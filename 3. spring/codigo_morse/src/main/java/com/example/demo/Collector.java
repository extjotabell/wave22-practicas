package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;

@RestController
public class Collector {

    protected static final String[] simbolos= {
            ".-",    // A
            "-...",  // B
            "-.-.",  // C
            "-..",   // D
            ".",     // E
            "..-.",  // F
            "--.",   // G
            "....",  // H
            "..",    // I
            ".---",  // J
            "-.-",   // K
            ".-..",  // L
            "--",    // M
            "-.",    // N
            "---",   // O
            ".--.",  // P
            "--.-",  // Q
            ".-.",   // R
            "...",   // S
            "-",     // T
            "..-",   // U
            "...-",  // V
            ".--",   // W
            "-..-",  // X
            "-.--",  // Y
            "--.."   // Z
    };
    private static final String[] abecedario = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };




    @GetMapping("/morse")
    private String morseAString(@RequestParam String codigoMorse){

        StringBuilder palabra = new StringBuilder();
        StringBuilder frase = new StringBuilder();
        frase.append("");
        StringBuilder simboloMorse = new StringBuilder();
        int contEspacios = 0;
        StringBuilder espacios = new StringBuilder();

        for(int i = 0; i < codigoMorse.length(); i++){
            String letra = String.valueOf(codigoMorse.charAt(i));
            if ( !letra.equals(" ")) {
                System.out.println(letra);
                simboloMorse.append(letra);
            }

            if (i > 1){
                String letraAnterior = String.valueOf(codigoMorse.charAt(i-1));
                if (letra.equals(" ") && letraAnterior.equals(" ")){
                    frase.append(" ");
                }
            }


            if (letra.equals(" ") && simboloMorse.length() >= 1){

//                System.out.println("letra detectada");
//                System.out.println("Frase: "+ frase.toString());
//                System.out.println("Simbolo morse: "+ simboloMorse.toString());
//                System.out.println("Simbolo morse largo: "+ simboloMorse.length());

                // buscar palabra
                int posicion = 0;  //

                for (int b = 0; b < simbolos.length; b ++){
                    if(simboloMorse.toString().equals(simbolos[b])){
                        posicion = b;
                        break;
                    }
                }
//                System.out.println("Posicion: " + posicion);
                simboloMorse.setLength(0);
                palabra.append(abecedario[posicion]);
                frase.append(palabra);
                palabra.setLength(0);

            }

        }

        //utlimo simbolo
        int posicion = 0;  //

        for (int b = 0; b < simbolos.length; b ++){
            if(simboloMorse.toString().equals(simbolos[b])){
                posicion = b;
                break;
            }
        }
        palabra.append(abecedario[posicion]);
        frase.append(palabra);
        // fin utlima palabra

//        System.out.println("------------");
        return frase.toString();
    }
}
