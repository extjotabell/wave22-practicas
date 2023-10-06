package com.example.joyeria.controller;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.service.IJoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    @Autowired
    IJoyeriaService service;

    @PostMapping("/new")
    public ResponseEntity<?> createJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(service.create(joyaDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll() , HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteById(id) , HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id_modificar,@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(service.update(id_modificar,joyaDTO), HttpStatus.CREATED);
    }
}
