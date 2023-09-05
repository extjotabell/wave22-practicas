package com.meli.numerosromanos.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NumeroService {
    private static Map<Integer, String> NUMEROS_ROMANOS = Map.of(
            1, "I",
            2, "II",
            3, "III",
            4, "IV",
            5, "V",
            6, "VI",
            7, "VII",
            8, "VIII",
            9, "IX",
            10, "X"
    );
    public static List<Map.Entry<Integer, String>> getNumerosRomanos() {
        List<Map.Entry<Integer, String>> numerosRomanos = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : NUMEROS_ROMANOS.entrySet()) {
            numerosRomanos.add(entry);
        }
        return numerosRomanos;
    }

    public String getNumeroRomanoByKey(Integer decimal){
        return NUMEROS_ROMANOS.get(decimal);
    }
}
