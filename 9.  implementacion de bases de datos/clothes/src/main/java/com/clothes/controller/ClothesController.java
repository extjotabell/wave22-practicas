package com.clothes.controller;

import com.clothes.dto.ClotheDto;
import com.clothes.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    IClothesService service;

    @GetMapping()
    public ResponseEntity<?> getAllClothes(@RequestParam(required = false) String name){
        if (name != null) {
            return new ResponseEntity<>(service.getAllClothesByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.getAllClothes(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> postNewClothes(@RequestBody ClotheDto dto){
        return new ResponseEntity<>(service.addClothe(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getClothes(@PathVariable Long code){
        return new ResponseEntity<>(service.getClothe(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateClothes(@PathVariable long code, @RequestBody ClotheDto clotheToUpdate){
        return new ResponseEntity<>(service.updateClothe(code, clotheToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothes(@PathVariable long code){
        return new ResponseEntity<>(service.deleteClothe(code), HttpStatus.OK);
    }

    @GetMapping("/BySize/{size}")
    public ResponseEntity<?> getClothesBySize(@PathVariable String size){
        return new ResponseEntity<>(service.getAllClothesBySize(size), HttpStatus.OK);
    }
}
