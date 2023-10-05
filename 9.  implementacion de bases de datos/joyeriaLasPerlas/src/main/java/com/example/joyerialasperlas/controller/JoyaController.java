package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyaController {

    @Autowired
    JoyaService service;

    @GetMapping("/jewerly")
    public ResponseEntity<?> getAllJewelry(){
        return new ResponseEntity<>(service.getAllJewelry(), HttpStatus.OK);
    }

    @GetMapping("/jewerly/{id}")
    public ResponseEntity<?> getJewelry(@PathVariable Long id){
        return new ResponseEntity<>(service.getJewelry(id), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Long id){
        service.deleteJewerly(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<?> updateJewelry(@PathVariable Long id_modificar, @RequestBody JoyaDto joyaAUpdatear){
        return new ResponseEntity<>(service.updateJewerly(id_modificar, joyaAUpdatear), HttpStatus.OK);
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> newJewelry(@RequestBody JoyaDto newJoya){
        return new ResponseEntity<>(service.saveJewerly(newJoya), HttpStatus.CREATED);
    }
}
