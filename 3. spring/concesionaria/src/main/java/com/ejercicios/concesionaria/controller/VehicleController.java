package com.ejercicios.concesionaria.controller;

import com.ejercicios.concesionaria.dto.RequestVehicleDTO;
import com.ejercicios.concesionaria.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RequestVehicleDTO vehicleObj){
        service.save(vehicleObj);
        return ResponseEntity.status(HttpStatus.OK).body("Vehiculo creado");
    }



    @GetMapping
    public  ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getByDate(@RequestParam LocalDate since,@RequestParam LocalDate to){
        return ResponseEntity.status(HttpStatus.OK).body(service.getByDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getByPrice(@RequestParam double since,@RequestParam double to){
        return ResponseEntity.status(HttpStatus.OK).body(service.getByPrice(since,to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

}
