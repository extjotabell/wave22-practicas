package com.numeroRomano.numeroRomano.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NRomanoController {

    @GetMapping("/{letra}")
    public String GetNumero(@PathVariable String letra){

        int sumNumero = 0;
        char[] chars = letra.toUpperCase().toCharArray();
        for(char l : chars) {
            switch (l) {
                case 'I':
                    sumNumero += 1;
                    break;
                case 'V':
                    sumNumero += 5;
                    break;
                case 'X':
                    sumNumero += 10;
                    break;
                case 'L':
                    sumNumero += 50;
                    break;
                case 'C':
                    sumNumero += 100;
                    break;
                case 'D':
                    sumNumero += 500;
                    break;
                case 'M':
                    sumNumero += 1000;
                    break;
            }
            ;
        }
        return   String.valueOf(sumNumero);
    }


}
