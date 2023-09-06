package com.practicos.Covid19.controller;

import com.practicos.Covid19.model.Sintoma;
import com.practicos.Covid19.repository.impl.SintomaImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("findSymptopm")
public class SintomasController {

    private final SintomaImpl sintomasImpl = new SintomaImpl();

    @GetMapping
    public ResponseEntity<List<Sintoma>> getAllSintomas(){
        return new ResponseEntity<>(sintomasImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Sintoma> getSintomaByName(@PathVariable String name){
        return new ResponseEntity<>(sintomasImpl.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSintoma(@RequestBody Sintoma sintoma){
        this.sintomasImpl.add(sintoma);
        return new ResponseEntity<>("Sintoma agregado: " + sintoma.getNombre(), HttpStatus.OK);
    }
}
