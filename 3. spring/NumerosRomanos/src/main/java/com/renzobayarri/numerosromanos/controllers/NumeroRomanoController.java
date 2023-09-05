package com.renzobayarri.numerosromanos.controllers;

import com.renzobayarri.numerosromanos.services.NumberConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class NumeroRomanoController {

    private NumberConverter numberConverter;

    @GetMapping("/{number}")
    public String getNumeroRomano(@PathVariable int number){
        return numberConverter.convert(number);
    }

}
