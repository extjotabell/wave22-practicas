package com.example.ejerciciocomida.controllers;

import com.example.ejerciciocomida.dtos.CaloriasDto;
import com.example.ejerciciocomida.dtos.IngredientDto;
import com.example.ejerciciocomida.services.IDishesService;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishesController {
    @Autowired
    IDishesService dishesService;

    @GetMapping("/dishes/calories/{name}")
    public ResponseEntity<?> getCalories(@PathVariable String name, @RequestParam Integer weigth){
        CaloriasDto calorias = dishesService.getCalories(name,weigth);
        return new ResponseEntity<>(calorias,HttpStatus.OK);
    }

    @GetMapping("/dishes/ingredients/{name}")
    public ResponseEntity<?> getIngredientes(@PathVariable String name){
        List<IngredientDto> ingredients = dishesService.getListIngredient(name);
        return new ResponseEntity<>(ingredients,HttpStatus.OK);
    }

    @GetMapping("/dishes/worstingredient/{name}")
    public ResponseEntity<?> getWorstIngrediente(@PathVariable String name){
        IngredientDto ingredient = dishesService.getWorstIngredient(name);
        return new ResponseEntity<>(ingredient,HttpStatus.OK);
    }



}
