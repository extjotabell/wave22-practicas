package com.concesionaria.autos.controller;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.service.IVehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiclesController {

    @Autowired
    IVehiclesService vehiclesService;

    @PostMapping("/")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDTO vehicle){

        int i = vehiclesService.addVehicle(vehicle);
        // To do...
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> usedVehicles(){
        List<VehicleDTO> vehicles = vehiclesService.getSelectedVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.FOUND);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> findPeerDate(@RequestParam LocalDate since, LocalDate to){
        List<VehicleDTO> vehicles = vehiclesService.getByDate(since,to);
        return new ResponseEntity<>(vehicles, HttpStatus.FOUND);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> findByPrice(@RequestParam double since, double to){
        List<VehicleDTO> vehicles = vehiclesService.getByPrice(since, to);
        return new ResponseEntity<>(vehicles, HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> findPeerDate(@PathVariable int id){
        VehicleDTO vehicle = vehiclesService.getById(id);
        return new ResponseEntity<>(vehicle, HttpStatus.FOUND);
    }
}
