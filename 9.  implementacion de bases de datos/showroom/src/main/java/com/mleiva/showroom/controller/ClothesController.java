package com.mleiva.showroom.controller;

import com.mleiva.showroom.entity.dto.ClothesDto;
import com.mleiva.showroom.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    IClothesService service;

    @PostMapping("")
    public ResponseEntity<?> guardarClothes(@RequestBody ClothesDto clothesDto){
        return new ResponseEntity<>(service.saveClothes(clothesDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllClothes(){
        return new ResponseEntity<>(service.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long code){
        return new ResponseEntity<>(service.findById(code),HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> actualizar(@PathVariable Long code, @RequestBody ClothesDto clothesDto){
        return new ResponseEntity<>(service.actualizar(code, clothesDto),HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long code){
        return new ResponseEntity<>(service.deleteClothes(code),HttpStatus.OK);
    }

    @GetMapping("/bysize/{size}")
    public ResponseEntity<?> obtenerPorTalle(@PathVariable String size){
        return new ResponseEntity<>(service.findAllBySize(size),HttpStatus.OK);
    }

    @GetMapping("/byname")
    public ResponseEntity<?> obtenerPorNameContaining(@RequestParam String name){
        return new ResponseEntity<>(service.findAllByNameContaining(name),HttpStatus.OK);
    }

}
