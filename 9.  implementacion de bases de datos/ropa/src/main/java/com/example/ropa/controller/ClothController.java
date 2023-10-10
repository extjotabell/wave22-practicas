package com.example.ropa.controller;

import com.example.ropa.dto.ClothDTO;
import com.example.ropa.service.IClothService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clothes")
@Validated
public class ClothController {

    @Autowired
    IClothService clothService;

    @PostMapping
    public ResponseEntity<ClothDTO> addCloth(@RequestBody ClothDTO clothDto){
        return ResponseEntity.ok(clothService.addCloth(clothDto));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ClothDTO>> getClothesByName(@PathVariable String name){
        return ResponseEntity.ok(clothService.getClothesByName(name));
    }

    @GetMapping
    public ResponseEntity<List<ClothDTO>> getAllClothes(){
        return ResponseEntity.ok(clothService.getAllClothes());
    }

    @GetMapping("code/{code}")
    public ResponseEntity<ClothDTO> getByCode(@PathVariable Integer code){
        return ResponseEntity.ok(clothService.getByCode(code));
    }

    @PutMapping("/{code}")
    public void updateCloth(@PathVariable Integer code, @RequestBody ClothDTO updatedCloth){
        clothService.updateCloth(code, updatedCloth);
    }

    @DeleteMapping("/{code}")
    public void deleteCloth(@PathVariable Integer code){
        clothService.deleteCloth(code);
    }

    @GetMapping("size/{size}")
    public ResponseEntity<List<ClothDTO>> getClothesBySize(@PathVariable Integer size){
        return ResponseEntity.ok(clothService.getClothesBySize(size));
    }

}
