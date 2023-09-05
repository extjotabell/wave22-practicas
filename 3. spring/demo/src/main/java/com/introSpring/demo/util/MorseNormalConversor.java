package com.introSpring.demo.util;

import java.util.HashMap;
import java.util.Map;

public class MorseNormalConversor {

    public String convertirMorse(String s){
        Map<String, String> morse = new HashMap<String, String>();
        morse.put(".-",   "a");
        morse.put("-...", "b");
        morse.put( "-.-.", "c");
        morse.put( "-..", "d");
        morse.put(".",    "e");
        morse.put("..-.", "f");
        morse.put( "--.", "g");
        morse.put("....", "h");
        morse.put(  "..", "i");
        morse.put(".---", "j");
        morse.put("-.-", "k");
        morse.put(".-..", "l");
        morse.put("--", "m");
        morse.put("-.", "n");
        morse.put( "---", "o");
        morse.put(".--.", "p");
        morse.put("--.-", "q");
        morse.put(".-.",  "r");
        morse.put( "...", "s");
        morse.put(  "-",  "t");
        morse.put( "..-", "u");
        morse.put("...-", "v");
        morse.put(".--", "w");
        morse.put("-..-", "x");
        morse.put("-.--", "y");
        morse.put("--..", "z");
        morse.put(".----","1");
        morse.put("..---","2");
        morse.put("...--","3");
        morse.put("....-","4");
        morse.put(".....","5");
        morse.put("-....","6");
        morse.put("--...","7");
        morse.put("---..","8");
        morse.put("----.","9");
        morse.put("-----","0");
        morse.put("..--..", "?");
        morse.put("-.-.--", "!");
        morse.put(".-.-.-", ".");
        morse.put("--..--", ",");

        return morse.get(s);

    }

    public String convertirNormal(String s){
        Map<String, String> normal = new HashMap<String, String>();
        normal.put("a", ".-");
        normal.put("b", "-...");
        normal.put("c", "-.-.");
        normal.put("d", "-..");
        normal.put("e", ".");
        normal.put("f", "..-.");
        normal.put("g", "--.");
        normal.put("h", "....");
        normal.put("i", "..");
        normal.put("j", ".---");
        normal.put("k", "-.-");
        normal.put("l", ".-..");
        normal.put("m", "--");
        normal.put("n", "-.");
        normal.put("o", "---");
        normal.put("p", ".--.");
        normal.put("q", "--.-");
        normal.put("r", ".-.");
        normal.put("s", "...");
        normal.put("t", "-");
        normal.put("u", "..-");
        normal.put("v", "...-");
        normal.put("w", ".--");
        normal.put("x", "-..-");
        normal.put("y", "-.--");
        normal.put("z", "--..");
        normal.put("1", ".----");
        normal.put("2", "..---");
        normal.put("3", "...--");
        normal.put("4", "....-");
        normal.put("5", ".....");
        normal.put("6", "-....");
        normal.put("7", "--...");
        normal.put("8", "---..");
        normal.put("9", "----.");
        normal.put("0", "-----");
        normal.put("?", "..--..");
        normal.put("!", "-.-.--");
        normal.put(".", ".-.-.-");
        normal.put(",", "--..--");

        return normal.get(s);

    }

}
