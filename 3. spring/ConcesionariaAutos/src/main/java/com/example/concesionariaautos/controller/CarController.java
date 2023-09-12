package com.example.concesionariaautos.controller;


import com.example.concesionariaautos.Service.CarService;
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
    CarService _service;

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody CarServiceDto carDto){
        _service.CreateCar(carDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public  ResponseEntity<List<CarDto>> getAllCar(){
        return ResponseEntity.ok(_service.AllCAr());
    }

    //Este enpoint se pasa como parametro los años para realizar la busqueda
    @GetMapping("/date")
    public ResponseEntity<List<CarServiceDto>> ge(@RequestParam int since, @RequestParam int to){
        return ResponseEntity.ok(_service.GetCarDate(since,to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarServiceDto>> getCarPrice(@RequestParam int since, @RequestParam int to){
        return ResponseEntity.ok(_service.GetCarPrice(since,to));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarServiceDto> getById(@PathVariable int id){
        return ResponseEntity.ok(_service.GetById(id));
    }


}
