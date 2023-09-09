package com.nicolassalvo.cardealership.controller;

import com.nicolassalvo.cardealership.dto.CarDTO;
import com.nicolassalvo.cardealership.dto.FullCarDTO;
import com.nicolassalvo.cardealership.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class CarController {
    @Autowired
    ICarService carService;
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllVehicles() {
        List<CarDTO> carDTOList = carService.getAllVehicles();
        return ResponseEntity.status(HttpStatus.OK).body(carDTOList);
    }

    @PostMapping
    public ResponseEntity<FullCarDTO> createVehicle(@RequestBody FullCarDTO car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.createCar(car));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<CarDTO>> getVehiclesByDate(@RequestParam LocalDate since) {
        List<CarDTO> carDTOList = carService.findCarsByDate(since);
        return ResponseEntity.status(HttpStatus.OK).body(carDTOList);
    }
    @GetMapping("/prices")
    public ResponseEntity<List<CarDTO>> getVehiclesByPrice(@RequestParam double since) {
        List<CarDTO> carDTOList = carService.findCarsByPrice(since);
        return ResponseEntity.status(HttpStatus.OK).body(carDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FullCarDTO> getVehicleById(@PathVariable int id) {
        FullCarDTO vehicleById = carService.getVehicleById(id);
        return ResponseEntity.status(HttpStatus.OK).body(vehicleById);
    }

}
