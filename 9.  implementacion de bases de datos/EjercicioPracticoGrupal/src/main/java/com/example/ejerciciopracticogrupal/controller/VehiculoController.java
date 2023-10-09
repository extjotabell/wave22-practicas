package com.example.ejerciciopracticogrupal.controller;

import com.example.ejerciciopracticogrupal.dto.response.*;
import com.example.ejerciciopracticogrupal.service.IVehiculoService;
import com.example.ejerciciopracticogrupal.service.VehiculoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehiculos")
@Validated
public class VehiculoController {

    @Autowired
    VehiculoServiceImpl vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<PatentesDTO> getAllPatentes(){
        return ResponseEntity.ok(vehiculoService.getAllPatentes());
    }

    @GetMapping("/patentesYMarcas")
    public ResponseEntity<List<VehiculoDTO>> getAllPatentesYMarcas(){
        return ResponseEntity.ok(vehiculoService.getAllPatentesYMarcas());
    }

    @GetMapping("/cuatroRuedasYActuales")
    public ResponseEntity<PatentesDTO> getAllVehiculos4RuedasYActuales(){
        return ResponseEntity.ok(vehiculoService.getAllVehiculos4RuedasYActuales());
    }

    @GetMapping("/perdidasEconomicas")
    public ResponseEntity<List<VehiculoDTO>> getAllPatentesYMarcasConPerdidaEconomica(){
        return ResponseEntity.ok(vehiculoService.getAllPatentesYMarcasConPerdidaEconomica());
    }

    @GetMapping("/perdidasEconomicasYTotales")
    public ResponseEntity<List<PerdidasPorVehiculoDTO>> getAllPatentesYMarcasConPerdidaEconomicaYTotal(){
        return ResponseEntity.ok(vehiculoService.getAllPatentesYMarcasConPerdidaEconomicaYTotal());
    }
}
