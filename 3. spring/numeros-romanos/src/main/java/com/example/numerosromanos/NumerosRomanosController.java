package com.example.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numerosRomanos")
public class NumerosRomanosController {

    @GetMapping
    public String getNumerosRomanos(@RequestParam Integer numero){
        return new NumeroRomano().toRoman(numero);
    }

    @GetMapping("/testAll")
    public String test(){
        NumeroRomano numeroRomano = new NumeroRomano();
        String test = "";
        for(int i = 1; i< 4000; i++){
            test += new NumeroRomano().toRoman(i) + "\n";
        }
        return test;
    }
}
