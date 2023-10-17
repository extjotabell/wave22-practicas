package com.example.automotriz.controller;

import com.example.automotriz.dto.SiniestroDTO;
import com.example.automotriz.dto.VehiculoDTO;
import com.example.automotriz.service.implement.SiniestroService;
import com.example.automotriz.service.implement.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seguro")
public class SeguroController {
    @Autowired
    VehiculoService vehiculoService;
    @Autowired
    SiniestroService siniestroService;

    @PostMapping("/vehiculo/crear")
    public ResponseEntity<?> crearVehiculo(@RequestBody VehiculoDTO dto){
        return ResponseEntity.ok(vehiculoService.crearVehiculo(dto));
    }

    @PostMapping("/siniestro/crear")
    public ResponseEntity<?> crearSiniestro(@RequestBody SiniestroDTO dto){
        return ResponseEntity.ok(siniestroService.crearSiniestro(dto));
    }

    @GetMapping("/vehiculo/denuncias/{id}")
    public ResponseEntity<?> obtenerVehiculoPorId(@PathVariable Long id){
        return ResponseEntity.ok(vehiculoService.buscarPorId(id));
    }

    @GetMapping("/siniestro/denuncias/{id}")
    public ResponseEntity<?> obtenerSiniestroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(siniestroService.buscarPorId(id));
    }

    // Listar las patentes de todos los vehículos registrados.
    @GetMapping("/vehiculos/patentes")
    public ResponseEntity<?> listarPatentesVehiculosRegistrados(){
        return ResponseEntity.ok(vehiculoService.listarPatentes());
    }

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @GetMapping("/vehiculos/patentesYMarcasOrderbyAnioFabricacion")
    public ResponseEntity<?> listarPatentesYMarcasOrderByAnio(){
        return ResponseEntity.ok(vehiculoService.listarPatentesYMarcasOrderbyAnioFabricacion());
    }

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @GetMapping("/vehiculos/patenteMasCuatroRuedasYFabricadosAnioActual")
    public ResponseEntity<?> listarPatenteMasCuatroRuedasYFabricadosAnioActual(){
        return ResponseEntity.ok(vehiculoService.listarPatenteMasCuatroRuedasYFabricadosAnioActual());
    }

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/vehiculos/siniestroMayorMilPesos")
    public ResponseEntity<?> listarVehiculosSiniestroMayorDiezMilPesos(){
        return ResponseEntity.ok(vehiculoService.listarVehiculosSiniestroMayorDiezMilPesos());
    }

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @GetMapping("/vehiculos/siniestroMayorMilPesosPerdidaTotal")
    public ResponseEntity<?> listarVehiculosSiniestroMayorDiezMilPesosPerdidaTotal(){
        return ResponseEntity.ok(vehiculoService.listarVehiculosSiniestroMayorDiezMilPesosPerdidaTotal());
    }

}
