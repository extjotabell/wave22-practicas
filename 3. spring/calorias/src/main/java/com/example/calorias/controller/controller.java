package com.example.calorias.controller;

import com.example.calorias.dto.PlatoDTO;
import com.example.calorias.dto.PlatoRespuestaDTO;
import com.example.calorias.service.PlatoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    private final PlatoService dishService;

    public controller(PlatoService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/calcular")
    public PlatoRespuestaDTO calculate(@RequestBody PlatoDTO dish){
        return dishService.calcularCalorias(dish);
    }

}
