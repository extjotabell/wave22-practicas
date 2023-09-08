package com.Meli.Covid19.controller;

import com.Meli.Covid19.model.Sintoma;
import com.Meli.Covid19.repository.ISintomasRepository;
import com.Meli.Covid19.repository.SintomasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SintomasController {


    ISintomasRepository sintomasRepository = new SintomasRepository();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> getAll(){
        return ResponseEntity.ok(sintomasRepository.getAll());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getByName(@PathVariable String nombre){

        Optional<Sintoma> sintoma = sintomasRepository.getByName(nombre);

        return ResponseEntity.ok("hola");
    }



    @PostMapping("/symptom")
    public ResponseEntity create(@RequestBody Sintoma sintoma){
        sintomasRepository.save(sintoma);
        return ResponseEntity.status(201).build();
    }
}
