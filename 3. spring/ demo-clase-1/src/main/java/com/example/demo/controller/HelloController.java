package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private String nombre;

    @GetMapping("/saludar")
    private String saludar(){
        return "Hola mundo";
    }

    @GetMapping("/nombresaludo/{name}")
    public String saludarUsuario(@PathVariable String name){
        return "Hola " + name;
    }

    @GetMapping("/saludarusuario")
    public String saludarUsuario2(@RequestParam String name){
        return "Hola don " + name;
    }
}
