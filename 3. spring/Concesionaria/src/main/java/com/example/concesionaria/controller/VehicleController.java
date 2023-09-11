package com.example.concesionaria.controller;

import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDTO vehicle){
        return new ResponseEntity<>(vehicleService.saveVehicle(vehicle), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getFromDates(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>(vehicleService.getFromDates(since,to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getFromPrices(@RequestParam Double since, @RequestParam Double to){
        return new ResponseEntity<>(vehicleService.getFromPrices(since,to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicle(@PathVariable Integer id){
        return new ResponseEntity<>(vehicleService.getVehicle(id), HttpStatus.OK);
    }
}
