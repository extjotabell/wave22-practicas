package com.escuela.sistemaEstudiantes.controller;

import com.escuela.sistemaEstudiantes.dtos.EstudianteDTO;
import com.escuela.sistemaEstudiantes.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstudianteController {
    @Autowired
    IEstudianteService service;

    @GetMapping("/estudiantes")
    public ResponseEntity<?> getAllEstudiantes(){
        List<EstudianteDTO> listaDeEstudiantes = service.getAllEstudiantes();
        return new ResponseEntity<>(listaDeEstudiantes, HttpStatus.OK);
    }

    //TODO: IMPLEMENTAR EL SAVE DE ESTUDIANTE
//    @PostMapping("/estudiantes/addStudent")
//    public ResponseEntity<?> agregarEstudiante(@RequestBody EstudianteDTO estudianteNuevo){
//        service.saveEstudiante(estudianteNuevo);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

}
