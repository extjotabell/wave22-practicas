package com.introSpring.sayHello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HelloController {
    private String nombre;

    @GetMapping("/saludar")
    public  String saludar(){
        return "Hello world";
    }

    @GetMapping("/user")
    public String saludarUsuario(@RequestParam String name){
        return "Hello " + name;
    }
}
