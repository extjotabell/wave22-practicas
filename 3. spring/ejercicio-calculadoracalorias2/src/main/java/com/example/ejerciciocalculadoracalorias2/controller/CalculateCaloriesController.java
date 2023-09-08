package com.example.ejerciciocalculadoracalorias2.controller;

import com.example.ejerciciocalculadoracalorias2.dto.DishRequestDTO;
import com.example.ejerciciocalculadoracalorias2.dto.DishResponseDTO;
import com.example.ejerciciocalculadoracalorias2.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalculateCaloriesController {

    @Autowired
    private IDishService dishService;

    @PostMapping("/getCalories")
    public ResponseEntity<DishResponseDTO> getCalories(@RequestBody DishRequestDTO dishRequestDTO) {
        return ResponseEntity.ok((dishService.calculateCalories(dishRequestDTO)));
    }

    @PostMapping("/getAllCalories")
    public ResponseEntity<List<DishResponseDTO>> getAllCalories(@RequestBody List<DishRequestDTO> dishRequestDTOS) {
        return ResponseEntity.ok(dishService.calculateAllCalories((dishRequestDTOS)));
    }

}
