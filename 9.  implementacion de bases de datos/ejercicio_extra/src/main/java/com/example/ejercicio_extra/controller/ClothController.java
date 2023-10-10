package com.example.ejercicio_extra.controller;

import com.example.ejercicio_extra.dto.ClothDTO;
import com.example.ejercicio_extra.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothController {

    @Autowired
    ClothService clothService;

    @PostMapping("")
    public ResponseEntity<?> createNewCloth(@RequestBody ClothDTO cloth){
        return new ResponseEntity<>(clothService.createNewCloth(cloth), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllClothes(){
        return new ResponseEntity<>(clothService.getAllClothes(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getCloth(@PathVariable String code){
        return new ResponseEntity<>(clothService.getCloth(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateCloth(@PathVariable String code, @RequestBody ClothDTO clothDTO){
        return new ResponseEntity<>(clothService.updateCloth(code, clothDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteCloth(@PathVariable String code){
        return new ResponseEntity<>(clothService.deleteCloth(code), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getClothesBySize(@PathVariable String size){
        return new ResponseEntity<>(clothService.getClothesBySize(size), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getClothesByName(@RequestParam String name){
        return new ResponseEntity<>(clothService.getClothesByName(name), HttpStatus.OK);
    }
}
