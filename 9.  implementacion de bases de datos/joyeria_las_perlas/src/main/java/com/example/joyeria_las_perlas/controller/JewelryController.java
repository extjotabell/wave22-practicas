package com.example.joyeria_las_perlas.controller;

import com.example.joyeria_las_perlas.dto.JewelDTO;
import com.example.joyeria_las_perlas.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jewelry")
public class JewelryController {

    @Autowired
    IJewelService jewelService;
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(jewelService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createJewel(@RequestBody JewelDTO jewelDTO) {
        return new ResponseEntity<>(jewelService.createJewel(jewelDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(jewelService.deleteJewel(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewel(@PathVariable Long id,@RequestBody JewelDTO updatedJewel) {
        return new ResponseEntity<>(jewelService.updateJewel(id, updatedJewel), HttpStatus.OK);

    }
}
