package com.example.DemoClaseDto.controller;

import com.example.DemoClaseDto.model.Persona;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @PostMapping("/guardar")
    public Persona guardarPersona(@RequestBody Persona p){
        System.out.print(p);
        p.setEdad(23);
        return p;
    }
}
