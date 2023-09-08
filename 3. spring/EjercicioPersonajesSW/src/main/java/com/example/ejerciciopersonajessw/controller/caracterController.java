package com.example.ejerciciopersonajessw.controller;

import com.example.ejerciciopersonajessw.dto.CaracterDto;
import com.example.ejerciciopersonajessw.service.ICaracterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class caracterController {

    @Autowired
    ICaracterService caracterService;

    @GetMapping("/caracter/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        List<CaracterDto> caracters = caracterService.getByName(name);
        return new ResponseEntity<>(caracters, HttpStatus.OK);
    }
}
