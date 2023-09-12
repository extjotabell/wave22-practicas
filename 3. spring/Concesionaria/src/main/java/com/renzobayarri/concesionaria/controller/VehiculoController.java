package com.renzobayarri.concesionaria.controller;

import com.renzobayarri.concesionaria.dto.VehiculoDTO;
import com.renzobayarri.concesionaria.dto.VehiculoWithoutServices;
import com.renzobayarri.concesionaria.service.VehiculoService;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
@AllArgsConstructor
public class VehiculoController {

    VehiculoService vehiculoService;

    @PostMapping("/")
    public ResponseEntity<String> saveVehicle(@RequestBody VehiculoDTO vehiculo) {
        vehiculoService.save(vehiculo);
        return new ResponseEntity<>("Vehiculo guardado con exito", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehiculoWithoutServices>> getAllVehicles() {
        return new ResponseEntity<>(vehiculoService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/dates")
    public ResponseEntity<List<VehiculoDTO>> getVehiclesByDate(@RequestParam @Nullable LocalDate since, @RequestParam @Nullable LocalDate to) {
        return new ResponseEntity<>(vehiculoService.findByManufacturingDateBetween(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehiculoDTO>> getVehiclesByPrice(@RequestParam @Nullable double from, @RequestParam @Nullable double to) {
        return new ResponseEntity<>(vehiculoService.findByPriceBetween(from, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> getVehicle(@PathVariable int id) {
        return new ResponseEntity<>(vehiculoService.findById(id), HttpStatus.OK);
    }


}
