package com.example.concesionaria.controller;

import com.example.concesionaria.dto.AutoDTO;
import com.example.concesionaria.dto.AutoServiceDTO;
import com.example.concesionaria.service.IAutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v1/api/vehicles")
@RequiredArgsConstructor
public class CarController {
    private final IAutoService carService;

    @PostMapping
    public ResponseEntity<AutoServiceDTO> createCar(@RequestBody AutoServiceDTO car) {
        return ResponseEntity.ok().body(carService.createCar(car));
    }

    @GetMapping
    public ResponseEntity<List<AutoDTO>> getAllCars() {
        return ResponseEntity.ok().body(carService.getCars());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<AutoServiceDTO> getCarById(@PathVariable int id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<AutoDTO>> getCarsByDate(@RequestParam String since) {
        return ResponseEntity.ok().body(carService.getCarsByDateSince(since));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<AutoDTO>> getCarsByPrice(@RequestParam double price) {
        return ResponseEntity.ok().body(carService.getCarsByPrice(price));
    }
}
