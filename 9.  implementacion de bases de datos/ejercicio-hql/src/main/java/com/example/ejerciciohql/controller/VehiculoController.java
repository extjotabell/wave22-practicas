package com.example.ejerciciohql.controller;

import com.example.ejerciciohql.dto.request.SiniestroRequestDTO;
import com.example.ejerciciohql.dto.request.VehiculoRequestDTO;
import com.example.ejerciciohql.dto.response.VehiculoResponseDTO;
import com.example.ejerciciohql.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @PostMapping("")
    public ResponseEntity<?> addVehiculo(@RequestBody VehiculoRequestDTO vehiculoRequestDTO) {
        vehiculoService.addVehiculo(vehiculoRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/siniestro/{idVehiculo}")
    public ResponseEntity<?> addSiniestro(@PathVariable Long idVehiculo, @RequestBody SiniestroRequestDTO siniestroRequestDTO) {
        vehiculoService.addSiniestro(idVehiculo, siniestroRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<VehiculoResponseDTO>> getAllVehiculos() {
        return new ResponseEntity<>(vehiculoService.findAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<VehiculoResponseDTO>> getAllPatentes() {
        return new ResponseEntity<>(vehiculoService.findAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentesAndMarcas")
    public ResponseEntity<List<VehiculoResponseDTO>> patentesAndMarcasOrderByAnio() {
        return new ResponseEntity<>(vehiculoService.findAllPatentesAndMarcas(), HttpStatus.OK);
    }

}
