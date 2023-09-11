package com.concesionaria.Concesionaria.controller;

import com.concesionaria.Concesionaria.dtos.CarDTO;
import com.concesionaria.Concesionaria.dtos.CarNoServicesDTO;
import com.concesionaria.Concesionaria.service.ConcesionariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class ConcesionariaController {
    @Autowired
    ConcesionariaService service;

    @PostMapping("/")
    public ResponseEntity<?> saveCar(@RequestBody CarDTO car){
        return ResponseEntity.ok(service.saveCar(car));
    }

    @GetMapping("/")
    public ResponseEntity<?> gatAll(){
        List<CarNoServicesDTO> cars = service.getAll();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getByDate(@RequestParam LocalDate date){
        List<CarDTO> cars = service.findByDate(date);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getByPrice(@RequestParam String price){
        List<CarDTO> cars = service.findByPrice(price);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        CarDTO car = service.findById(id);
        return ResponseEntity.ok(car);
    }
}
