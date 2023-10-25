package com.movies.demoHQL.controller;

import com.movies.demoHQL.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    @Autowired
    IVehicleService service;

    @GetMapping("/getAllPatentes")
    public ResponseEntity<?> getAllPatentes(){
        return new ResponseEntity<>(service.allPatentes(), HttpStatus.OK);
    }

    @GetMapping("/getAllPatentesYMarca")
    public ResponseEntity<?> getAllPatentesYMarca(){
        return new ResponseEntity<>(service.allPapentesYMarca(), HttpStatus.OK);
    }



}
