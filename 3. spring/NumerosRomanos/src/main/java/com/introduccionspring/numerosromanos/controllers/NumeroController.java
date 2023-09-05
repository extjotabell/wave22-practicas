package com.introduccionspring.numerosromanos.controllers;

import com.introduccionspring.numerosromanos.dao.entity.Numero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NumeroController {
    @GetMapping
    public String probandoEndpoint(){
        return "Mostrando mensaje de prueba";
    }
    @GetMapping("/roman/{number}")
    public String parseToRoman(@PathVariable int number) {
        Numero numero = new Numero(number);
        return numero.convertirARomano(number);
    }
}
