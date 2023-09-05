package com.example.numerosromanos;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class NumeroRomano {
    private final static Map<Integer, String> romanMap = new HashMap<>();

    public NumeroRomano() {
        romanMap.put(1,"I");
        romanMap.put(4, "IV");
        romanMap.put(5,"V");
        romanMap.put(9,"IX");
        romanMap.put(10,"X");
        romanMap.put(40,"XL");
        romanMap.put(50,"L");                                                                                  
        romanMap.put(90,"LC");
        romanMap.put(100,"C");
        romanMap.put(400,"CD");
        romanMap.put(500,"D");
        romanMap.put(900,"CM");
        romanMap.put(1000,"M");
    }

    public String toRoman(Integer num){
        String roman = "";
        if(num > 3999 || num < 1) {
            return "Wrong number";
        }
        for(Integer i : romanMap.keySet().stream().sorted(Comparator.reverseOrder()).toList()){
            while(num >= i){
                roman += romanMap.get(i);
                num -= i;
            }
        }
        return roman;
    }
}
