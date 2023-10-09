package com.mleiva.impljpa.joyerialasperlas.controller;

import com.mleiva.impljpa.joyerialasperlas.dto.JewerlyDTO;
import com.mleiva.impljpa.joyerialasperlas.service.JewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JewerlyController {

    @Autowired
    JewerlyService service;

    @GetMapping("/jewerly")
    public ResponseEntity<?> getAllJewelry(){
        return new ResponseEntity<>(service.getAllJewerlys(), HttpStatus.OK);
    }

    @GetMapping("/jewerly/{id}")
    public ResponseEntity<?> getJewelry(@PathVariable Long id){
        return new ResponseEntity<>(service.findJewerly(id), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Long id){
        service.deleteJewerly(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/jewerly/update/{id}")
    public ResponseEntity<?> updateJewelry(@PathVariable Long id, @RequestBody JewerlyDTO jewerlyDTO){
        return new ResponseEntity<>(service.updateJewerly(id, jewerlyDTO), HttpStatus.OK);
    }

    @PostMapping("/jewerly")
    public ResponseEntity<Long> newJewelry(@RequestBody JewerlyDTO jewerly){
        return new ResponseEntity<>(service.saveJewerly(jewerly), HttpStatus.CREATED);
    }
}
