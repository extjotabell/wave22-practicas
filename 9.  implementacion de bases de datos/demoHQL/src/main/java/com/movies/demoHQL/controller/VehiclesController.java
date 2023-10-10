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
    public ResponseEntity<?> getAllPatentes() {
        return new ResponseEntity<>(service.allPatentes(), HttpStatus.OK);
    }

    @GetMapping("/getAllPatentesYMarca")
    public ResponseEntity<?> getAllPatentesYMarca() {
        return new ResponseEntity<>(service.allPatentesYMarca(), HttpStatus.OK);
    }

    @GetMapping("/getVehiclesWithSiniestrosGreaterThan10000")
    public ResponseEntity<?> getVehiculosConSiniestrosMayorA10000() {
        return new ResponseEntity<>(service.vehiculosConSiniestrosMayorA10000(), HttpStatus.OK);
    }

    @GetMapping("/getVehiclesAndSumWithSiniestrosGreaterThan10000")
    public ResponseEntity<?> getVehiculosAndSumConSiniestrosMayorA10000() {
        return new ResponseEntity<>(service.vehiculosAndSumConSiniestrosMayorA10000(), HttpStatus.OK);
    }

}
