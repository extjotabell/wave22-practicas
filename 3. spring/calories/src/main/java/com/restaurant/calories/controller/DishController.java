package com.restaurant.calories.controller;

import com.restaurant.calories.dto.DishDetailsDTO;
import com.restaurant.calories.service.IDishDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {
    @Autowired
    IDishDetailService service;

    @GetMapping("/dish/{name}/{weight}")
    ResponseEntity<?> getDishDetails(@PathVariable String name, @PathVariable double weight){
        return new ResponseEntity<DishDetailsDTO> (getDishDetailsDTO(name,weight), HttpStatus.OK);
    }

    public DishDetailsDTO getDishDetailsDTO(String name, double weight){
        service.
    }
}
