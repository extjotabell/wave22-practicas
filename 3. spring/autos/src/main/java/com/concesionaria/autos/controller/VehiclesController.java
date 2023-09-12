package com.concesionaria.autos.controller;

import com.concesionaria.autos.dto.VehicleDTO;
import com.concesionaria.autos.service.IVehiclesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiclesController {
    IVehiclesService vehiclesService;
    public VehiclesController(IVehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    @PostMapping("/")
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicle){
        return new ResponseEntity<>(vehiclesService.addVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> usedVehicles(){
        List<VehicleDTO> vehicles = vehiclesService.getSelectedVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> findPeerDate(@RequestParam LocalDate since, LocalDate to){
        List<VehicleDTO> vehicles = vehiclesService.getByDate(since,to);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> findByPrice(@RequestParam double since, double to){
        List<VehicleDTO> vehicles = vehiclesService.getByPrice(since, to);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> findPeerDate(@PathVariable int id){
        VehicleDTO vehicle = vehiclesService.getById(id);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }
}
