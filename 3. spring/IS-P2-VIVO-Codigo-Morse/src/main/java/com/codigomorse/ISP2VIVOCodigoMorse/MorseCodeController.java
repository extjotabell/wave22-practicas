package com.codigomorse.ISP2VIVOCodigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

@RestController
@RequestMapping("/morse")
public class MorseCodeController {
    private HashMap<String, Character> morseToCharactersDictionary;

    public MorseCodeController() {
        this.morseToCharactersDictionary = new HashMap<>();
        morseToCharactersDictionary.put(".-", 'A');
        morseToCharactersDictionary.put("-...", 'B');
        morseToCharactersDictionary.put("-.-.", 'C');
        morseToCharactersDictionary.put("-..", 'D');
        morseToCharactersDictionary.put(".", 'E');
        morseToCharactersDictionary.put("..-.", 'F');
        morseToCharactersDictionary.put("--.", 'G');
        morseToCharactersDictionary.put("....", 'H');
        morseToCharactersDictionary.put("..", 'I');
        morseToCharactersDictionary.put(".---", 'J');
        morseToCharactersDictionary.put("-.-", 'K');
        morseToCharactersDictionary.put(".-..", 'L');
        morseToCharactersDictionary.put("--", 'M');
        morseToCharactersDictionary.put("-.", 'N');
        morseToCharactersDictionary.put("---", 'O');
        morseToCharactersDictionary.put(".--.", 'P');
        morseToCharactersDictionary.put("--.-", 'Q');
        morseToCharactersDictionary.put(".-.", 'R');
        morseToCharactersDictionary.put("...", 'S');
        morseToCharactersDictionary.put("-", 'T');
        morseToCharactersDictionary.put("..-", 'U');
        morseToCharactersDictionary.put("...-", 'V');
        morseToCharactersDictionary.put(".--", 'W');
        morseToCharactersDictionary.put("-..-", 'X');
        morseToCharactersDictionary.put("-.--", 'Y');
        morseToCharactersDictionary.put("--..", 'Z');
        morseToCharactersDictionary.put("-----", '0');
        morseToCharactersDictionary.put(".----", '1');
        morseToCharactersDictionary.put("..---", '2');
        morseToCharactersDictionary.put("...--", '3');
        morseToCharactersDictionary.put("....-", '4');
        morseToCharactersDictionary.put(".....", '5');
        morseToCharactersDictionary.put("-....", '6');
        morseToCharactersDictionary.put("--...", '7');
        morseToCharactersDictionary.put("---..", '8');
        morseToCharactersDictionary.put("----.", '9');
        morseToCharactersDictionary.put(".-.-.-", '.');
        morseToCharactersDictionary.put("--..--", ',');
        morseToCharactersDictionary.put("-.-.--", '!');
        morseToCharactersDictionary.put("..--..", '?');
        morseToCharactersDictionary.put("", ' ');
    }

    @GetMapping()
    public String morseToCharacters(@RequestParam String morseCode){
        StringBuilder morseConverted = new StringBuilder();
        for (String morseCodeCharacter: morseCode.split("\\s{2}|\\s")) {
            morseConverted.append(this.morseToCharactersDictionary.get(morseCodeCharacter));
        }

        /*
        Another solution:
        for (String morseCodeWord: morseCode.split("   ")) {
            StringBuilder morseWordConverted = new StringBuilder();
            for (String morseCodeCharacter: morseCodeWord.split(" ")) {
                morseWordConverted.append(this.morseToCharactersDictionary.get(morseCodeCharacter));
            }
            morseConverted.append(morseWordConverted.toString());
            morseConverted.append(' ');
        }
        */
        return morseConverted.toString();
    }
}
