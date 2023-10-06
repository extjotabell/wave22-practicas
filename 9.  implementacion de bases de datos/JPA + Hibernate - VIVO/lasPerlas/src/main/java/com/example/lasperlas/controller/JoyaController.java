package com.example.lasperlas.controller;

import com.example.lasperlas.dto.CreateResponseDto;
import com.example.lasperlas.dto.JoyaDto;
import com.example.lasperlas.service.JoyaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
@RequiredArgsConstructor
public class JoyaController {

    private final JoyaService joyaService;

    @PostMapping
    public ResponseEntity<CreateResponseDto> createJewel(@RequestBody JoyaDto joya){
        long id = joyaService.createJewel(joya);
        CreateResponseDto response = new CreateResponseDto("nro identificatorio " + id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JoyaDto>> findAll(){
        return ResponseEntity.ok(joyaService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJewel(@PathVariable long id){
        joyaService.deleteJewel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JoyaDto> updateJewel(@PathVariable long id, @RequestBody JoyaDto joyaDto){
        joyaService.updateJewel(id, joyaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
