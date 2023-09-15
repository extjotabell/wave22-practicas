package com.concesionariaDeAutos.concesionariaDeAutos.controller;

import com.concesionariaDeAutos.concesionariaDeAutos.dto.MessageDto;
import com.concesionariaDeAutos.concesionariaDeAutos.dto.VehicleDto;
import com.concesionariaDeAutos.concesionariaDeAutos.service.IServiceVehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final IServiceVehicle service;

    public Controller(IServiceVehicle service) {
        this.service = service;
    }

    @PostMapping("/v1/api/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){
        service.addVehicle(vehicleDto);
        return new ResponseEntity<>(new MessageDto("Vehicle created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/v1/api/vehicles")
    public ResponseEntity<?> getAllVehicles(){
        return new ResponseEntity<>(service.getAllVehicles(), HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/dates")
    public ResponseEntity<?> getVehiclesPerDate(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>(service.getVehiclesPerDate(since, to), HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/prices")
    public ResponseEntity<?> getVehiclesPerPrice(@RequestParam double since, @RequestParam double to){
        return new ResponseEntity<>(service.getVehiclesPerPrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/v1/api/vehicles/{id}")
    public ResponseEntity<?> getVehiclePerId(@PathVariable int id){
        return new ResponseEntity<>(service.getVehiclePerId(id), HttpStatus.OK);
    }
}
