package com.Meli.Romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conversor")
public class RomanosController {

    @GetMapping("/{numero}")
    public String conversor(@PathVariable String numero){

        return "Procesando solicitud....";
    }
}
