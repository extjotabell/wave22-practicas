package com.example.concesionariaautos.controller;


import com.example.concesionariaautos.service.CarService;
import com.example.concesionariaautos.dto.CarDto;
import com.example.concesionariaautos.dto.CarServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {

    @Autowired
    CarService service;

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody CarServiceDto carDto){
        service.createCar(carDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars(){
        return ResponseEntity.ok(service.getAllCars());
    }

    @GetMapping("/date")
    public ResponseEntity<List<CarServiceDto>> getCarDate(@RequestParam Integer since, @RequestParam Integer to){
        return ResponseEntity.ok(service.getCarDate(since,to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarServiceDto>> getCarPrice(@RequestParam Integer since, @RequestParam Integer to){
        return ResponseEntity.ok(service.getCarPrice(since,to));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarServiceDto> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }


}
