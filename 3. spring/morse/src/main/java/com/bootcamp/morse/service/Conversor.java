package com.bootcamp.morse.service;

import java.util.HashMap;
import java.util.Map;

public class Conversor {
    String textoATransformar;

    public Conversor(String textoATransformar) {
        this.textoATransformar = textoATransformar;
    }

    public String pasarANormal(){
        String[] splitPalabras = textoATransformar.split("   ");
        String fraseTraducida = "";
        for (String word : splitPalabras){
            String[] splitLetras = word.split(" ");
            for (String letra : splitLetras){
                fraseTraducida += transformarLetraANormal(letra);
            }
            fraseTraducida += " ";
        }
        return fraseTraducida;
    }

    public String pasarAMorse(){
        String resultadoEnMorse = "";
        String[] splitCaracteres = textoATransformar.split("");
        for (String letra : splitCaracteres){
            resultadoEnMorse += transformarLetraAMorse(letra) + " ";
        }
        return resultadoEnMorse;
    }

    public String transformarLetraAMorse(String letra){
        Map<String, String> mapaNormalAMorse = new HashMap<String, String>();
        mapaNormalAMorse.put("a", ".-");
        mapaNormalAMorse.put("b", "-...");
        mapaNormalAMorse.put("c",  "-.-");
        mapaNormalAMorse.put("d",  "-..");
        mapaNormalAMorse.put("e",    ".");
        mapaNormalAMorse.put("f", "..-.");
        mapaNormalAMorse.put("g",  "--.");
        mapaNormalAMorse.put("h", "....");
        mapaNormalAMorse.put("i",   "..");
        mapaNormalAMorse.put("j", ".---");
        mapaNormalAMorse.put("k",   "-.-");
        mapaNormalAMorse.put("l", ".-..");
        mapaNormalAMorse.put("m",   "--");
        mapaNormalAMorse.put("n",   "-.");
        mapaNormalAMorse.put("o",  "---");
        mapaNormalAMorse.put("p", ".--.");
        mapaNormalAMorse.put("q", "--.-");
        mapaNormalAMorse.put("r", ".-.");
        mapaNormalAMorse.put("s",  "...");
        mapaNormalAMorse.put("t",   "-");
        mapaNormalAMorse.put("u",  "..-");
        mapaNormalAMorse.put("v", "...-");
        mapaNormalAMorse.put("w",  ".--");
        mapaNormalAMorse.put("x", "-..-");
        mapaNormalAMorse.put("y", "-.--");
        mapaNormalAMorse.put("z", "--..");
        mapaNormalAMorse.put(" ", " ");

        return mapaNormalAMorse.get(letra);
    }

    public String transformarLetraANormal(String letra){
        Map<String, String> mapaMorseANormal = new HashMap<String, String>();
        mapaMorseANormal.put(".-",   "a");
        mapaMorseANormal.put("-...", "b");
        mapaMorseANormal.put( "-.-.", "c");
        mapaMorseANormal.put( "-..", "d");
        mapaMorseANormal.put(".",    "e");
        mapaMorseANormal.put("..-.", "f");
        mapaMorseANormal.put( "--.", "g");
        mapaMorseANormal.put("....", "h");
        mapaMorseANormal.put(  "..", "i");
        mapaMorseANormal.put(".---", "j");
        mapaMorseANormal.put("-.-", "k");
        mapaMorseANormal.put(".-..", "l");
        mapaMorseANormal.put("--", "m");
        mapaMorseANormal.put("-.", "n");
        mapaMorseANormal.put( "---", "o");
        mapaMorseANormal.put(".--.", "p");
        mapaMorseANormal.put("--.-", "q");
        mapaMorseANormal.put(".-.",  "r");
        mapaMorseANormal.put( "...", "s");
        mapaMorseANormal.put(  "-",  "t");
        mapaMorseANormal.put( "..-", "u");
        mapaMorseANormal.put("...-", "v");
        mapaMorseANormal.put(".--", "w");
        mapaMorseANormal.put("-..-", "x");
        mapaMorseANormal.put("-.--", "y");
        mapaMorseANormal.put("--..", "z");
        mapaMorseANormal.put(".----","1");
        mapaMorseANormal.put("..---","2");
        mapaMorseANormal.put("...--","3");
        mapaMorseANormal.put("....-","4");
        mapaMorseANormal.put(".....","5");
        mapaMorseANormal.put("-....","6");
        mapaMorseANormal.put("--...","7");
        mapaMorseANormal.put("---..","8");
        mapaMorseANormal.put("----.","9");
        mapaMorseANormal.put("-----","0");
        mapaMorseANormal.put("..--..", "?");
        mapaMorseANormal.put("-.-.--", "!");
        mapaMorseANormal.put(".-.-.-", ".");
        mapaMorseANormal.put("--..--", ",");

        return mapaMorseANormal.get(letra);
    }
}
