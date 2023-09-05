package com.example.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseCode {
    private static final Map<String, Character> morseCodeMap = new HashMap<>();
    private static final Map<Character, String> reverseMorseCodeMap = new HashMap<>();

    public MorseCode() {
        populateMap();
    }

    private String convertToWords(String morseCode) {
        String[] words = morseCode.split("   ");
        String buffer = "";
        for (String word: words) {
            String[] letters = word.split(" ");
            for (String character: letters) {
                Character convertedLetter = morseCodeMap.get(character);
                buffer += convertedLetter;
            }
            buffer += " ";
        }
        return buffer;
    }

    private String convertToMorseCode(String phrase) {
        String[] words = phrase.split(" ");
        String buffer = "";
        for (String word : words) {
            String[] letters = word.split("");
            for (String letter : letters) {
                String letterCode = reverseMorseCodeMap.get(letter.charAt(0));
                buffer += letterCode;
                buffer += " ";
            }
            buffer += "  ";
        }
        return buffer;
    }



    @GetMapping("/decode/{morseCode}")
    public String getDecipheredCode(@PathVariable String morseCode) {
        return convertToWords(morseCode);
    }
    @GetMapping("/encode/{code}")
    public String getCipheredCode(@PathVariable String code) {
        return convertToMorseCode(code);
    }
    private void populateMap() {
        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("..-", 'U');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');
        morseCodeMap.put("-----", '0');
        morseCodeMap.put(".----", '1');
        morseCodeMap.put("..---", '2');
        morseCodeMap.put("...--", '3');
        morseCodeMap.put("....-", '4');
        morseCodeMap.put(".....", '5');
        morseCodeMap.put("-....", '6');
        morseCodeMap.put("--...", '7');
        morseCodeMap.put("---..", '8');
        morseCodeMap.put("----.", '9');
        morseCodeMap.put("..--..", '?');
        morseCodeMap.put("-.-.--", '!');
        morseCodeMap.put(".-.-.-", '.');
        morseCodeMap.put("--..--", ',');

        morseCodeMap.forEach((key, value)->{
            reverseMorseCodeMap.put(value, key);
        });
    }
}
