package com.numerosRomanos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NumerosRomanosController {

    private static final Map<Integer, String> numerosRomanos = new HashMap<>();

    static {
        numerosRomanos.put(1, "I");
        numerosRomanos.put(2, "II");
        numerosRomanos.put(3, "III");
        numerosRomanos.put(4, "IV");
        numerosRomanos.put(5, "V");
        numerosRomanos.put(7, "VII");
        numerosRomanos.put(10, "X");
        numerosRomanos.put(50, "L");
        numerosRomanos.put(100, "C");
        numerosRomanos.put(500, "D");
        numerosRomanos.put(1000, "M");
    }

    @GetMapping("/numeroRomano/{numero}")
    public ResponseEntity<String> getNumeroRomanoAsociado(@PathVariable("numero") Integer numeroDecimal) {
        return numerosRomanos.containsKey(numeroDecimal) ?
                ResponseEntity.ok(numerosRomanos.get(numeroDecimal)) :
                new ResponseEntity<>("No se encuentra el numero romano equivalente", HttpStatus.NOT_FOUND);
    }
}
