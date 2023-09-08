package com.spring.calculadora_de_calorias.web.controllers;

import com.spring.calculadora_de_calorias.services.IPlatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PlatoController {

    private final IPlatoService iPlatoService;

    @GetMapping("/plato/{nombrePlato}")
    ResponseEntity<Integer> obtenerTotalCaloriasPlato(@PathVariable String nombrePlato) {
        return ResponseEntity.ok(iPlatoService.getTotalCaloriasPlato(nombrePlato));
    }
}
