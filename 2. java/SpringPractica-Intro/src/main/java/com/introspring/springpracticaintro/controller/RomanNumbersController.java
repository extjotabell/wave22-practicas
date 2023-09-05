package com.introspring.springpracticaintro.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

//recibir las http request del cliente.
@RestController
public class RomanNumbersController {

    private String nombre;

    @GetMapping
    public String saludar(){
        return "Hello World";
    }

}
