package com.example.springpracticascalcucolorias.controller;

import com.example.springpracticascalcucolorias.dto.GetPlatoDto;
import com.example.springpracticascalcucolorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    @Autowired
    IPlatoService platoService;

    @GetMapping("/getPlato/{name}/{peso}")
    public GetPlatoDto getPlato(@PathVariable String name, @PathVariable int peso){
        return platoService.getPlato(name, peso);
    }

}
