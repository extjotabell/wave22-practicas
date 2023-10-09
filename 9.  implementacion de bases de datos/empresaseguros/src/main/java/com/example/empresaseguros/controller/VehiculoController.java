package com.example.empresaseguros.controller;

import com.example.empresaseguros.dto.VehiculoDTO;
import com.example.empresaseguros.dto.responce.VehiculoPatenteDTO;
import com.example.empresaseguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    IVehiculoService service;

    @PostMapping("/new")
    public ResponseEntity<?> createVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        return new ResponseEntity<>(service.create(vehiculoDTO),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll() , HttpStatus.OK);
    }

    @GetMapping("/4ruedasesteaño")
    public ResponseEntity<?> getVehiculosMasDe4RuedasFabricadosEsteAño(){
        //return new ResponseEntity<>(service.)
        return null;

    }

    @GetMapping("/patentes")
    public List<VehiculoPatenteDTO> getPatentes(){
        return service.getAllPatentes();
    }
}
