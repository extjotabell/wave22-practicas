package com.meli.calculadoracalorias.controller;

import com.meli.calculadoracalorias.dto.PlatoDTO;
import com.meli.calculadoracalorias.model.Ingredient;
import com.meli.calculadoracalorias.model.Plato;
import com.meli.calculadoracalorias.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

 /*   Cantidad total de calorías del plato
    Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
    El ingrediente con mayor cantidad de calorías
*/

    @GetMapping("/plato/calorias/{name}/{peso}")
    public ResponseEntity<Double> getCaloriasTotales(@PathVariable String name, @PathVariable Double weight){
        return ResponseEntity.ok(service.getCaloriasTotales(name, weight));
    }

    public ResponseEntity<PlatoDTO> getTotalIngredients(){

    }


}
