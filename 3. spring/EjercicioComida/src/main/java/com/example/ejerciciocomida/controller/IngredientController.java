package com.example.ejerciciocomida.controller;

import com.example.ejerciciocomida.dto.IngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getIngredients() {
    return new ResponseEntity(ingredientService.getIngredients(), HttpStatus.OK);
    }

}
