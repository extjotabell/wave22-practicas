package com.spring.edaddeunapersona.controllers;

import com.spring.edaddeunapersona.entities.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Api funcionando correctamente";
    }

    @GetMapping("/{dia}/{mes}/{año}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int año) {
        Persona p = new Persona();
        return p.calcularEdad(dia, mes, año);
    }
}
