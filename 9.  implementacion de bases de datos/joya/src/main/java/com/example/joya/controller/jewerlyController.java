package com.example.joya.controller;

import com.example.joya.dto.JewerlyDto;
import com.example.joya.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class jewerlyController {

    @Autowired
    IJewerlyService service;

    @PostMapping("/new")
    public ResponseEntity<Long> createJewerly(@RequestBody JewerlyDto jewerlyDto){
        return ResponseEntity.ok(service.createJewerly(jewerlyDto));
    }

    @GetMapping
    public ResponseEntity<List<JewerlyDto>>  getall(){
        return ResponseEntity.ok(service.getJewerlyAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JewerlyDto> deleteJewerly(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteJewerly(id));
    }

    @PutMapping("update/{id_modificar}")
    public ResponseEntity<JewerlyDto> updateJewerly(@PathVariable Long id_modificar, @RequestBody JewerlyDto jewerlyDto){
        return ResponseEntity.ok(service.updateJewerly(jewerlyDto,id_modificar));
    }

}
