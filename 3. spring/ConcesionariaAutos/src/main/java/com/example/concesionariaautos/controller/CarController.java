package com.example.concesionariaautos.controller;


import com.example.concesionariaautos.Service.ICarService;
import com.example.concesionariaautos.dto.CarDto;
import com.example.concesionariaautos.dto.CarServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {

    @Autowired
    ICarService _service;
    @PostMapping
    public ResponseEntity<?> CreateCar(@RequestBody CarServiceDto carDto){
        _service.CreateCar(carDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public  ResponseEntity<List<CarDto>> AllCar(){
        return ResponseEntity.ok(_service.AllCAr());
    }
    @GetMapping("/date")
    public ResponseEntity<List<CarServiceDto>> DateCar(@RequestParam String since){
        return ResponseEntity.ok(_service.GetCarDate(since));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarServiceDto>> GetCarPrice(@RequestParam int since, @RequestParam int to){
        return ResponseEntity.ok(_service.GetCarPrice(since,to));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarServiceDto> GetById(@PathVariable int id){
        return ResponseEntity.ok(_service.GetById(id));
    }


}
