package com.calculadoraCalorias.CalculadoraCalorias.controller;

import com.calculadoraCalorias.CalculadoraCalorias.dtos.DishCaloriesDTO;
import com.calculadoraCalorias.CalculadoraCalorias.dtos.DishDTO;
import com.calculadoraCalorias.CalculadoraCalorias.service.CaloriesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaloriesController {

    @Autowired
    CaloriesServiceImp service;

    @PostMapping("/dish")
    public ResponseEntity<DishCaloriesDTO>calculate(@RequestBody DishDTO dish){
        return ResponseEntity.ok(service.calculateDish(dish));
    }

    @PostMapping("/dishes")
    public ResponseEntity<List<DishCaloriesDTO>> calculareAll(@RequestBody List<DishDTO> dishes){
        return ResponseEntity.ok(service.calculateDishAll(dishes));
    }
}
