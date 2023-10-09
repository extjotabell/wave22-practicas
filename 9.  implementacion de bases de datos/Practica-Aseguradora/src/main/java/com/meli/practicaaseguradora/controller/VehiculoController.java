package com.meli.practicaaseguradora.controller;

import com.meli.practicaaseguradora.dto.VehiculoDTO;
import com.meli.practicaaseguradora.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<VehiculoDTO>> getAll(){
        return ResponseEntity.ok(vehiculoService.findAll());
    }

    @GetMapping("/patentes")
    public  ResponseEntity<?> getPatentes(){
        return ResponseEntity.ok(vehiculoService.getAllPatentes());
    }

    @GetMapping("/patentes/marcas")
    public ResponseEntity<?> getAllPatentesMarcas(){
        return  ResponseEntity.ok(vehiculoService.getAllPatentesMarcas());
    }

    @GetMapping("/patentes/ruedas")
    public  ResponseEntity<?> getPatentesRuedasAnioActual(){
        return ResponseEntity.ok(vehiculoService.getPatenteRuedasAnioActual());
    }

    @GetMapping("/perdidas")
    public ResponseEntity<?> getPerdidas (){
        return ResponseEntity.ok(vehiculoService.getPerdidas());
    }

//    @GetMapping("/perdidas/total")
//    public  ResponseEntity<?> getPerdidasTotal(){
//        return ResponseEntity.ok(vehiculoService.getPerdidasTotal());
//    }
}
