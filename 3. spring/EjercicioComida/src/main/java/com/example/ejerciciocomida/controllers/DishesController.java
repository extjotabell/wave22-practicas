package com.example.ejerciciocomida.controllers;

import com.example.ejerciciocomida.services.IDishesService;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishesController {
    @Autowired
    IDishesService dishesService;

    @GetMapping("/dishes/calories/{name}")
    public ResponseEntity<?> getCalories(@PathVariable String name, @RequestParam Integer weigth){
        Double calorias = dishesService.getCalories(name,weigth);
        return new ResponseEntity<>("Todo Ok "+calorias,HttpStatus.OK);
    }
}
