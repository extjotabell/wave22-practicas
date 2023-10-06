package com.example.joyeria.controller;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.service.IJoyeriaService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    @Autowired
    IJoyeriaService service;

    //1
    @PostMapping("/new")
    public ResponseEntity<?> createJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(service.create(joyaDTO), HttpStatus.CREATED);
    }

    //2
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll() , HttpStatus.OK);
    }

    //3
    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(service.eliminar(id), HttpStatus.OK);
    }

    //4
    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> update(@PathVariable("id_modificar") Long id, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(service.updateJewel(id,joyaDTO), HttpStatus.OK);
    }

}
