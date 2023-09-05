package com.example.morsecode;

import java.util.HashMap;

public class MorseCode {
    private HashMap<String, String> morseCodeMap;

    public MorseCode() {
        this.morseCodeMap = new HashMap<>();

        morseCodeMap.put(".-", "a");
        morseCodeMap.put("-...", "b");
        morseCodeMap.put("-.-.", "c");
        morseCodeMap.put("-..", "d");
        morseCodeMap.put(".", "e");
        morseCodeMap.put("..-.", "f");
        morseCodeMap.put("--.", "g");
        morseCodeMap.put("....", "h");
        morseCodeMap.put("..", "i");
        morseCodeMap.put(".---", "j");
        morseCodeMap.put("-.-", "k");
        morseCodeMap.put(".-..", "l");
        morseCodeMap.put("--", "m");
        morseCodeMap.put("-.", "n");
        morseCodeMap.put("---", "o");
        morseCodeMap.put(".--.", "p");
        morseCodeMap.put("--.-", "q");
        morseCodeMap.put(".-.", "r");
        morseCodeMap.put("...", "s");
        morseCodeMap.put("-", "t");
        morseCodeMap.put("..-", "u");
        morseCodeMap.put("...-", "v");
        morseCodeMap.put(".--", "w");
        morseCodeMap.put("-..-", "x");
        morseCodeMap.put("-.--", "y");
        morseCodeMap.put("--..", "z");
        morseCodeMap.put("-----", "0");
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put("..--..", "?");
        morseCodeMap.put("-.-.--", "!");
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");
    }

    public String toString(String text){
        String[] palabras = text.split("   ");
        StringBuilder oracionFinal = new StringBuilder();
        for(String s : palabras){
            String[] caracter = s.split(" ");
            for(String c : caracter){
                oracionFinal.append(this.morseToChar(c));
            }
            oracionFinal.append(" ");
        }
        return oracionFinal.toString().strip().toUpperCase();
    }

    private String morseToChar(String c){
        return morseCodeMap.get(c);
    }
}
