package com.example.ejerciciocomida.controller;

import com.example.ejerciciocomida.dto.FoodDto;
import com.example.ejerciciocomida.dto.IngredientDto;
import com.example.ejerciciocomida.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class FoodController {

    @Autowired
    private IFoodService comidaService;


    @GetMapping("/cantidadTotalCalorias")
    public ResponseEntity<Integer> getCantidadTotalCalorias(@RequestBody List<FoodDto> foods){
        return new ResponseEntity(comidaService.getCantidadTotalCalorias(), HttpStatus.OK);
    }
    @GetMapping("/listadoIngredientes")
    public ResponseEntity<List<IngredientDto>> getListadoIngredientes(@RequestBody List<FoodDto> foods){
        return new ResponseEntity(comidaService.getListadoIngredientes(), HttpStatus.OK);
    }

    @GetMapping("/ingredienteMayorCantidadCalorias")
    public ResponseEntity<IngredientDto> getIngredienteMayorCantidadCalorias(@RequestBody List<FoodDto> foods){
        return new ResponseEntity(comidaService.getIngredienteMayorCantidadCalorias(),HttpStatus.OK);
    }
}
