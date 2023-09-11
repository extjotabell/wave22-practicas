package com.bootcamp.calories.controller;

import com.bootcamp.calories.dto.CalorieReportDTO;
import com.bootcamp.calories.service.ICaloricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalorieController {

    @Autowired
    ICaloricService calorieService;

    @GetMapping("/calories/dish/{dish}/grams/{grams}")
    public ResponseEntity<CalorieReportDTO> getCalorieReport(@PathVariable String dish, @PathVariable int grams){
        return new ResponseEntity<>(calorieService.getCalorieReport(dish, grams), HttpStatus.OK) ;
    }

}
