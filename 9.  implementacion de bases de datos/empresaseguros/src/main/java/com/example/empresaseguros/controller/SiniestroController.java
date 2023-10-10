package com.example.empresaseguros.controller;

import com.example.empresaseguros.dto.SiniestroDTO;
import com.example.empresaseguros.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    @Autowired
    ISiniestroService service;

    @PostMapping("/new")
    public ResponseEntity<?> createSiniestro(@RequestBody SiniestroDTO siniestroDTO){
        return new ResponseEntity<>(service.create(siniestroDTO), HttpStatus.CREATED);
    }
}
