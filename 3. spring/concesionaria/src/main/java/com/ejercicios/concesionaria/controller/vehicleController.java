package com.ejercicios.concesionaria.controller;

import com.ejercicios.concesionaria.dto.VehiclesDTOS;
import com.ejercicios.concesionaria.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class vehicleController {

    @Autowired
    IService service;

    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody VehiclesDTOS vehiclesDTOS){
        return new ResponseEntity<>(service.save(vehiclesDTOS), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public  ResponseEntity<?> getDAtes(@RequestParam LocalDate startDate, LocalDate endDate){
        return ResponseEntity.status(HttpStatus.OK).body(service.getDates(startDate,endDate));
    }

    @GetMapping("/prices")
    public  ResponseEntity<?> getDAtes(@RequestParam Double minPrice, Double maxPrice){
        return ResponseEntity.status(HttpStatus.OK).body(service.getPrices(minPrice,maxPrice));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getDAtes(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
}
