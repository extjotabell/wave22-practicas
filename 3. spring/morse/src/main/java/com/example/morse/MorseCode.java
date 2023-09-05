package com.example.morse;
import java.util.HashMap;
import java.util.Map;

public class MorseCode {
    private static final Map<String, String> traducciones = new HashMap<>();

    static {
        traducciones.put(".-", "A");
        traducciones.put("-...", "B");
        traducciones.put("-.-.", "C");
        traducciones.put("-..", "D");
        traducciones.put(".", "E");
        traducciones.put("..-.", "F");
        traducciones.put("--.", "G");
        traducciones.put("....", "H");
        traducciones.put("..", "I");
        traducciones.put(".---", "J");
        traducciones.put("-.-", "K");
        traducciones.put(".-..", "L");
        traducciones.put("--", "M");
        traducciones.put("-.", "N");
        traducciones.put("---", "O");
        traducciones.put(".--.", "P");
        traducciones.put("--.-", "Q");
        traducciones.put(".-.", "R");
        traducciones.put("...", "S");
        traducciones.put("-", "T");
        traducciones.put("..-", "U");
        traducciones.put("...-", "V");
        traducciones.put(".--", "W");
        traducciones.put("-..-", "X");
        traducciones.put("-.--", "Y");
        traducciones.put("--..", "Z");
    }

    public static String translate(String codigoMorse) {
        StringBuilder resultado = new StringBuilder();
        String[] palabras = codigoMorse.split("   ");
        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for (String letra : letras) {
                if (traducciones.containsKey(letra)) {
                    resultado.append(traducciones.get(letra));
                } else {
                    resultado.append("?");
                }
            }
            resultado.append(" ");
        }
        return resultado.toString().trim();
    }
}
