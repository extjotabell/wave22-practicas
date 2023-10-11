package com.example.showroom.controller;

import com.example.showroom.dto.ClothesDTO;
import com.example.showroom.entity.Clothes;
import com.example.showroom.service.IShowroomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clothes")
public class ShowroomController {

    private final IShowroomService showroomService;

    @PostMapping("/")
    public ResponseEntity<?> createNewClothes(@RequestBody ClothesDTO clothesDTO){
        return new ResponseEntity<>(showroomService.createClothes(clothesDTO), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getClothes(){
        return new ResponseEntity<>(showroomService.getClothes(), HttpStatus.OK);
    }
    @GetMapping("/{code}")
    public ResponseEntity<?> getClothesByCode(@PathVariable String code){
        return new ResponseEntity<>(showroomService.getClothesByCode(code), HttpStatus.OK);
    }
    @PutMapping("/{code}")
    public ResponseEntity<?> updateClothesByCode(@RequestBody ClothesDTO clothesDTO, @PathVariable String code){
        return new ResponseEntity<>(showroomService.updateClothesByCode(clothesDTO,code), HttpStatus.OK);
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothesByCode(@PathVariable String code){
        return new ResponseEntity<>(showroomService.deleteClothesByCode(code), HttpStatus.OK);
    }
    @GetMapping("/size/{size}")
    public ResponseEntity<?> getClothesBySize(@PathVariable String size){
        return new ResponseEntity<>(showroomService.getClothesBySize(size), HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<?> getClothesByName(@RequestParam String name){
        return new ResponseEntity<>(showroomService.getClothesByName(name), HttpStatus.OK);
    }
}
