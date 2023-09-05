package com.bootcamp.morse.controller;

import com.bootcamp.morse.service.Conversor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/conversorMorseANormal")
    public String conversorMorseANormal(@RequestParam String morse){
        System.out.println("Recibí: " + morse);
        Conversor conversor1 = new Conversor(morse);
        String respuesta = conversor1.pasarANormal();
        System.out.println("Devuelvo: " + respuesta);
        return respuesta;
    }

    @GetMapping("/conversorNormalAMorse")
    public String conversorNormalAMorse(@RequestParam String normal){
        System.out.println("Recibí: " + normal);
        Conversor conversor1 = new Conversor(normal);
        String respuesta = conversor1.pasarAMorse();
        System.out.println("Devuelvo: " + respuesta);
        return respuesta;
    }
}
