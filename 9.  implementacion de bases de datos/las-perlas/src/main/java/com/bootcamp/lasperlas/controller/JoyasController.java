package com.bootcamp.lasperlas.controller;

import com.bootcamp.lasperlas.dto.JoyaDTO;
import com.bootcamp.lasperlas.service.JoyasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JoyasController {
    private final JoyasService joyasService;

    public JoyasController(JoyasService joyasService) {
        this.joyasService = joyasService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(this.joyasService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> newJewel(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(this.joyasService.createJewel(joyaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(this.joyasService.deleteJewel(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewel(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(this.joyasService.updateJewel(id, joyaDTO), HttpStatus.OK);
    }

}
