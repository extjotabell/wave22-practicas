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
        service.saveCar(car);
        return ResponseEntity.ok("Auto cargado con exito");
    }

    @GetMapping("/")
    public ResponseEntity<?> gatAll(){
        List<CarNoServicesDTO> cars = service.getAll();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getByDate(@RequestParam LocalDate since, @RequestParam LocalDate to){
        List<CarDTO> cars = service.findByDate(since,to);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getByPrice(@RequestParam String since, @RequestParam String to){
        List<CarDTO> cars = service.findByPrice(since, to);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        CarDTO car = service.findById(id);
        return ResponseEntity.ok(car);
    }
}
