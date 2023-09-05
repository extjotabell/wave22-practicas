package com.numerosRomanos.ApiNumerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController()
public class Controller {
    public static Map map = new LinkedHashMap<String, Integer>();

    @GetMapping("/api/convertir")
    public String convertirRomanoADecimal(@RequestParam int num){

        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        String result = "";
        int number = num;
        while(number > 0){
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String, Integer> entry = it.next();
                if(number >= entry.getValue()){
                    number -= entry.getValue();
                    result += entry.getKey();
                    break;
                }
            }
        }
        return result;
    }
}
