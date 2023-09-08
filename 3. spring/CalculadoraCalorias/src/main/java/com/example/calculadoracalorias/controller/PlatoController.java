package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {
    @Autowired
    private PlatoService platoService;

    @GetMapping("/calorias")
    public ResponseEntity<Integer> getPlato(@RequestParam String name, @RequestParam Integer peso){
        return new ResponseEntity<>(platoService.getCaloriasPlato(name, peso), HttpStatus.OK);
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<List<IngredienteDTO>> getIngredientes(@RequestParam String name, @RequestParam Integer peso){
        return new ResponseEntity<>(platoService.getCaloriasIngredientes(name, peso), HttpStatus.OK);
    }

    @GetMapping("/ingredientes/maxcal")
    public ResponseEntity<IngredienteDTO> getMaxCal(@RequestParam String name, @RequestParam Integer peso){
        return new ResponseEntity<>(platoService.getCaloriasMax(name, peso), HttpStatus.OK);
    }

    

}
