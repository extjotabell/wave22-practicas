package com.example.ConcesionariaAutos.controller;

import com.example.ConcesionariaAutos.dto.VehicleDTO;
import com.example.ConcesionariaAutos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class VehiclesController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Integer> addVehicle(@RequestBody VehicleDTO vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getVehicles(){
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesSince(@RequestParam LocalDate since, @RequestParam LocalDate to){
        return new ResponseEntity<>(vehicleService.getVehiclesByDate(since, to), HttpStatus.OK);
    }

    @GetMapping("prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesFromPrice(@RequestParam Double from, @RequestParam Double to){
        return new ResponseEntity<>(vehicleService.getVehiclesByPrice(from, to), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int id){
        return new ResponseEntity<>(vehicleService.getVehicleById(id), HttpStatus.OK);
    }

}
