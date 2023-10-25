package com.example.empresaseguros.controller;

import com.example.empresaseguros.dto.VehiculoDTO;
import com.example.empresaseguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService service;

    @PostMapping("/new")
    public ResponseEntity<?> createVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        return new ResponseEntity<>(service.create(vehiculoDTO),HttpStatus.CREATED);
    }

    @GetMapping("patentes")
    public ResponseEntity<?> getAllLicensePlate(){
        return new ResponseEntity<>(service.getAllLicensePlate() , HttpStatus.OK);
    }

    @GetMapping("/patenteymarca")
    public ResponseEntity<?> obtenerVehiculoOrdenadoPorAñoDeFabricacion(){
        return ResponseEntity.ok(service.obtenerPatenteYMarcaOrdenadoPorAñoDeFabricacion());
    }

    @GetMapping("/4ruedasesteaño")
    public ResponseEntity<?> getVehiculosMasDe4RuedasFabricadosEsteAño(){
        return ResponseEntity.ok(service.obtenerPatenteDeVehiculosMasde4Ruedas());
    }

    @GetMapping("/siniestros10000")
    public ResponseEntity<?> ObtenerVehiculosConSiniestroMayorA10000(){
        return ResponseEntity.ok(service.obtenerVehiculosConSiniestroMayorA10000());
    }

    // TODO: Hacer este endpoint
    @GetMapping("/sumaSiniestros10000")
    public ResponseEntity<?> ObtenerVehiculosConSiniestroMayorA10000ConPerdidaEconomicaTotal(){
        return ResponseEntity.ok(service.obtenerVehiculosConSiniestroMayorA10000());
    }
}
