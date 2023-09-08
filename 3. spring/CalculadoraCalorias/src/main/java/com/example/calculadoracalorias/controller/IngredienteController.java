package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public ResponseEntity<List<IngredienteDTO>> getAllIngredientes(){
        return new ResponseEntity<>(this.ingredienteService.getAllIngredientes(), HttpStatus.OK);
    }
}
