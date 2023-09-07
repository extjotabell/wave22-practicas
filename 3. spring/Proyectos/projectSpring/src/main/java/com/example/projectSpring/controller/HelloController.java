package com.example.projectSpring.controller;

import org.springframework.web.bind.annotation.*;

// Aca voy a recibir las peticiones del cliente con el protocolo HTTP
@RestController // Usamos esta anotacion para que sepa q esta es mi capa de acceso
public class HelloController {
    private String nombre;

    @GetMapping()
    private String saludar(){
        return "Hello world";
    }

   /* @GetMapping("/saludar/{name}")
    private String saludar(@PathVariable String name){
        return "Hello world" + name;
    }*/

    @GetMapping("/user")
    public String saludarUsuario(@RequestParam String name, @RequestParam String surname){
        return "Hello " + name + " " + surname;
    }



}
