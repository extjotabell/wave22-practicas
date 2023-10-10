package com.example.showroom.controller;

import com.example.showroom.dto.GarmentDTO;
import com.example.showroom.entity.Garment;
import com.example.showroom.service.IServiceClothes;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class GarmentController {
    @Autowired
    IServiceClothes service;

    //Post /api/clothes
    @PostMapping
    public ResponseEntity<?> postGarment(@RequestBody GarmentDTO garmentDTO){
        return new ResponseEntity<>(service.postGarment(garmentDTO), HttpStatus.OK);
    }

    //GET /api/clothes?name=remera
    @GetMapping
    public ResponseEntity<?> getByName(@RequestParam(required = false) String name){
        return new ResponseEntity<>(service.getGarmentByName(name), HttpStatus.OK);
    }

    //GET /api/clothes/{code}
    @GetMapping("/{id}")
    public ResponseEntity<?> getClotheById(@PathVariable Long id){
        return new ResponseEntity<>(service.getGarmentById(id), HttpStatus.OK);
    }

    //PUT /api/clothes/{code}
    @PutMapping("/{id}")
    public ResponseEntity<?> editGarmentById(@PathVariable Long id, @RequestBody GarmentDTO garmentDTO){
        return new ResponseEntity<>(service.editGarment(id, garmentDTO), HttpStatus.OK);
    }

    //DELETE /api/clothes/{code]
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGarmentById(@PathVariable Long id){
        return new ResponseEntity<>(service.removeGarment(id), HttpStatus.OK);
    }

    //GET /api/clothes/size/{size}
    @GetMapping("/size/{size}")
    public ResponseEntity<?> searchBySize(@PathVariable String size){
        return new ResponseEntity<>(service.getGarmentBySize(size), HttpStatus.OK);
    }

}
