package com.meli.numerosromanos.controller;

import com.meli.numerosromanos.service.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/numeros")
public class NumeroController {

    @Autowired
    private NumeroService service;
    @GetMapping("/diccionario")
    public List<Map.Entry<Integer, String>> getNumerosRomanos(){
        return service.getNumerosRomanos();
    }

    @GetMapping("/diccionario/{decimal}")
    public String getNumeroRomanoByDecimal(@PathVariable Integer decimal){
        return service.getNumeroRomanoByKey(decimal);
    }
}
