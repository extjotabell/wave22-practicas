package com.example.lasperlas.controller;

import com.example.lasperlas.dto.JoyaDTO;
import com.example.lasperlas.model.Joya;
import com.example.lasperlas.service.LasPerlasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class LasPerlasController {

    @Autowired
    LasPerlasService lasPerlasService;

    @PostMapping("/new")
    public ResponseEntity<String> saveJoya(@RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<>("La joya ha sido guardada con exito con id #" + lasPerlasService.saveJoya(joyaDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JoyaDTO>> getAll() {
        return new ResponseEntity<>(lasPerlasService.getAllJoyas(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Long id) {
        return new ResponseEntity<>(lasPerlasService.deleteJoya(id), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<JoyaDTO> updateJoya(@PathVariable Long id, @RequestBody JoyaDTO joyaNewInfo) throws Exception {
        return new ResponseEntity<>(lasPerlasService.updateJoyaById(id, joyaNewInfo), HttpStatus.OK);
    }

}
