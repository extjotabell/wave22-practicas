package com.calculadoraDeCalorias.calculadoraDeCalorias.controller;

import com.calculadoraDeCalorias.calculadoraDeCalorias.dto.DishDto;
import com.calculadoraDeCalorias.calculadoraDeCalorias.entity.Dish;
import com.calculadoraDeCalorias.calculadoraDeCalorias.service.IServiceCalculadora;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final IServiceCalculadora service;

    public Controller(IServiceCalculadora service) {
        this.service = service;
    }

    @GetMapping("/dish/{name}/{weight}")
    public ResponseEntity<?> getAllDishes(@PathVariable String name, @PathVariable double weight){
        return new ResponseEntity<>(service.getDish(name, weight), HttpStatus.OK);
    }
}
