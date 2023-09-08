package com.nicolassalvo.cardealership.controller;

import com.nicolassalvo.cardealership.dto.CarDTO;
import com.nicolassalvo.cardealership.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
