package com.miprimerproyecto.pruebaspring.controller;

import com.miprimerproyecto.pruebaspring.model.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class HolaRestController {

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello World " + name;
    }

    @GetMapping("/user")
    public String saludarUsuario(@RequestParam String name, @RequestParam String surname){
        return "hola " + name + " " + surname;
    }

    @GetMapping("/convert/{number}")
    public String toRoman(@PathVariable Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numbersToCompare.length; i++)
            for (; number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);
        return romanNumber.toString();
    }

    @PostMapping("/save")
    public Persona save(@RequestBody Persona p){
        System.out.println(p);
        p.setEdad(24);
        HashMap<String,String> diccionario = new HashMap<>();
        diccionario.put("code1","hello");
        diccionario.put("code2","hello2");
        p.setDic(diccionario);
        p.setList(List.of("Hola Lista", "Hola Lista2"));
        return p;
    }
}
