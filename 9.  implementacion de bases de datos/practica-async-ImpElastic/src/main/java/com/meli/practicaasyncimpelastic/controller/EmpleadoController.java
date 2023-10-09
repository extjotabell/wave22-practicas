package com.meli.practicaasyncimpelastic.controller;

import com.meli.practicaasyncimpelastic.model.Empleado;
import com.meli.practicaasyncimpelastic.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.findAll());
    }

    @GetMapping("/edad")
    public ResponseEntity<?> getByEdad(String edad) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(empleadoService.findByEdad(edad));
    }

    @PostMapping
    public  ResponseEntity<?> create(Empleado empleado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado));
    }
}
