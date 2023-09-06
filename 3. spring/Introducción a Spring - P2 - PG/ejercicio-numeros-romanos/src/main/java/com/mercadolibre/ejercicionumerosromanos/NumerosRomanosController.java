package com.mercadolibre.ejercicionumerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    private static final int[] valores = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static final String[] romanos = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    @GetMapping("/romano/{num}")
    public String convertirIntARomano(@PathVariable int num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < valores.length; i++) {
            while(num >= valores[i]) {
                sb.append(romanos[i]);
                num = num - valores[i];
            }
        }
        return sb.toString();
    }


}
