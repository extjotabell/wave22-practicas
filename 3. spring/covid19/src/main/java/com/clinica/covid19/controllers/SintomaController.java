package com.clinica.covid19.controllers;

import com.clinica.covid19.DBMock.DBMock;
import com.clinica.covid19.classes.Sintoma;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SintomaController {
    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findSymptom(@RequestParam(value = "name", required = false) String name){
        if(name == null){
            return new ResponseEntity<>(DBMock.sintomas, HttpStatus.OK);
        }
        else {
            List<Sintoma> sint = DBMock.sintomas.stream().filter(x->x.getNombre().equals(name)).collect(Collectors.toList());

            return new ResponseEntity<>(sint, HttpStatus.OK);
        }
    }
}
