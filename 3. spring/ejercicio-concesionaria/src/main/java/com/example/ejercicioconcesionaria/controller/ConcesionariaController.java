package com.example.ejercicioconcesionaria.controller;

import com.example.ejercicioconcesionaria.dto.VehicleRequestDTO;
import com.example.ejercicioconcesionaria.dto.VehicleResponseDTO;
import com.example.ejercicioconcesionaria.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ConcesionariaController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicles")
    public ResponseEntity<String> addVehicle(VehicleRequestDTO vehicle) {
        vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok("Vehicle added");
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleResponseDTO>> getVehicles() {
        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesByManufacturingDate(@RequestParam String since, @RequestParam String to) {
        return ResponseEntity.ok(vehicleService.getVehiclesByManufacturingDate(since, to));
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<VehicleResponseDTO>> getVehiclesByPrice(@RequestParam int since, @RequestParam int to) {
        return ResponseEntity.ok(vehicleService.getVehiclesByPrice(since, to));
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicle(@PathVariable int id) {
        return ResponseEntity.ok(vehicleService.getVehicle(id));
    }


}
