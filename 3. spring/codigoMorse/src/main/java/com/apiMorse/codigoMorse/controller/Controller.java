package com.apiMorse.codigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/convert")
    public String convertMorse(@RequestParam String morseText){
        StringBuilder result = new StringBuilder();
        String[] words = morseText.split("   ");
        for(String word : words){
            String[] letters = word.split(" ");
            for(String letter : letters){
                char character = morseToChar(letter);
                result.append(character);
            }
            result.append(" ");
        }
        return result.toString();
    }

    public char morseToChar(String morse){
        return switch (morse) {
            case ".-" -> 'A';
            case "-..." -> 'B';
            case "-.-." -> 'C';
            case "-.." -> 'D';
            case "." -> 'E';
            case "..-." -> 'F';
            case "--." -> 'G';
            case "...." -> 'H';
            case ".." -> 'I';
            case ".---" -> 'J';
            case "-.-" -> 'K';
            case ".-.." -> 'L';
            case "--" -> 'M';
            case "-." -> 'N';
            case "---" -> 'O';
            case ".--." -> 'P';
            case "--.-" -> 'Q';
            case ".-." -> 'R';
            case "..." -> 'S';
            case "-" -> 'T';
            case "..-" -> 'U';
            case "...-" -> 'V';
            case ".--" -> 'W';
            case "-..-" -> 'X';
            case "-.--" -> 'Y';
            case "--.." -> 'Z';
            case "-----" -> '0';
            case ".----" -> '1';
            case "..---" -> '2';
            case "...--" -> '3';
            case "....-" -> '4';
            case "....." -> '5';
            case "-...." -> '6';
            case "--..." -> '7';
            case "---.." -> '8';
            case "----." -> '9';
            default -> ' ';
        };
    }
}
