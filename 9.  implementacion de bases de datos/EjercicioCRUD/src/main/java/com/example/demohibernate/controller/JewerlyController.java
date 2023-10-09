package com.example.demohibernate.controller;

import com.example.demohibernate.dto.JewerlyDto;
import com.example.demohibernate.service.IJewerlyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/jewerly")
public class JewerlyController {

    private IJewerlyService jewerlyService;

    @PostMapping("/new")
    public ResponseEntity<?> addJew(@RequestBody JewerlyDto newJew) {
        return new ResponseEntity<>(jewerlyService.saveJewerly(newJew), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<?> getJewerly(){
        return new ResponseEntity<>(jewerlyService.getJewerly(), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteJew(@PathVariable long id){
        jewerlyService.deleteJewerly(id);
        return new ResponseEntity<>("Joya con ID: " + id + " eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJew(@PathVariable long id_modificar, @RequestBody JewerlyDto jewUpdate){
        jewerlyService.updateJewerly(id_modificar, jewUpdate);
        return new ResponseEntity<>("Joya con ID: " + id_modificar + " modificada correctamente", HttpStatus.OK);
    }


}
