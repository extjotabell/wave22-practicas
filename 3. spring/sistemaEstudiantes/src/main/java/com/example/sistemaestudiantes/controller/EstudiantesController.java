package com.example.sistemaestudiantes.controller;

import com.example.sistemaestudiantes.model.EstudianteDTO;
import com.example.sistemaestudiantes.service.EstudianteService;
import com.example.sistemaestudiantes.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstudiantesController {

    @Autowired // Otra forma de inicializar el servicio es con este flag
    IEstudianteService service; // Gracias al polimorfismo aca podria venir cualquier clase que
                                // implemente esta interfaz y va a funcionar.
    // Los modificadores de acceso no hace falta ponerlos en el controller

    // Una forma de inicializar el servicio: desde el constructor
    // public EstudiantesController(IEstudianteService service) {
    //     this.service = service;
    // }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteDTO>> getAllEstudiantes(){
        List<EstudianteDTO> listaDeEstudiantes = service.getAllEstudiantes();

        return new ResponseEntity<>(listaDeEstudiantes, HttpStatus.OK);
    }

}
