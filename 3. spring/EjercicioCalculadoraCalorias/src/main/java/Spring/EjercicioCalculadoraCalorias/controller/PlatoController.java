package Spring.EjercicioCalculadoraCalorias.controller;


import Spring.EjercicioCalculadoraCalorias.Dtos.IngredientDTO;
import Spring.EjercicioCalculadoraCalorias.Service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatoController {

    @Autowired
    private IPlatoService service;

 /*   Cantidad total de calorías del plato
    Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
    El ingrediente con mayor cantidad de calorías
*/

    @GetMapping("/plato/calorias/{name}")
    public ResponseEntity<Double> getCaloriasTotales(@PathVariable String name, @RequestParam Double weight){
        return ResponseEntity.ok(service.getCaloriasTotales(name, weight));
    }

    @GetMapping("/plato/ingredientes/{name}")
    public ResponseEntity<List<IngredientDTO>> getTotalIngredientsByPlato(@PathVariable String name){
        return ResponseEntity.ok(service.getIngredientesByPlato(name));
    }

    @GetMapping("/ingredientes/mayorCalorias")
    public ResponseEntity<IngredientDTO> getIngredienteConMayorCalorias()
    {
        return ResponseEntity.ok(service.highestIngredientCalories());
    }
}