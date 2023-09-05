package com.introduccionspring.codigomorse.controllers;

import com.introduccionspring.codigomorse.dao.entity.Dictionary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MorseController {

    @GetMapping
    public String testApi() {
        return "El endpoint esta funcando correctamente";
    }
    @GetMapping("/morse/{word}")
    public String convertRomanToWord(@PathVariable String word) {
        return Dictionary.decode(word);
    }
}
