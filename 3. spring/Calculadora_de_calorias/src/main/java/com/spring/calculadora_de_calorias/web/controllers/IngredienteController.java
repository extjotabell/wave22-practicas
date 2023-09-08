package com.spring.calculadora_de_calorias.web.controllers;

import com.spring.calculadora_de_calorias.entities.Ingrediente;
import com.spring.calculadora_de_calorias.services.IIngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IngredienteController {

    private final IIngredienteService iIngredienteService;
    @GetMapping("/{nombrePlato}")
    ResponseEntity<Map<Ingrediente, Double>> obtenerIngredientesYCaloriasPlato(@PathVariable String nombrePlato) {
        return ResponseEntity.ok(iIngredienteService.getIngredientesYCalorias(nombrePlato));
    }

    @GetMapping("/ingredientes/{nombrePlato}")
    ResponseEntity<Ingrediente> obtenerIngredienteConMayorCalorias(@PathVariable String nombrePlato) {
        return ResponseEntity.ok(iIngredienteService.getIngredienteConMaxCalorias(nombrePlato));
    }
}
