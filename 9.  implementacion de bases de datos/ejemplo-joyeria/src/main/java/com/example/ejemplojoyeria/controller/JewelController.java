package com.example.ejemplojoyeria.controller;

import com.example.ejemplojoyeria.dto.request.JewelRequestDTO;
import com.example.ejemplojoyeria.dto.response.JewelResponseDTO;
import com.example.ejemplojoyeria.dto.response.ResponseDTO;
import com.example.ejemplojoyeria.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelController {

    @Autowired
    private JewelService jewelService;

    @PostMapping("/jewelry/new")
    public ResponseEntity<ResponseDTO> createJewel(@RequestBody JewelRequestDTO jewelRequestDTO) {
        return new ResponseEntity<>(jewelService.saveJewel(jewelRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/jewelry")
    public ResponseEntity<List<JewelResponseDTO>> getJewels() {
        return ResponseEntity.ok(jewelService.getJewels());
    }

    @PutMapping("/jewelry/update/{jewelId}")
    public ResponseEntity<JewelResponseDTO> updateJewel(@PathVariable Long jewelId, @RequestBody JewelRequestDTO jewelRequestDTO) {
        return ResponseEntity.ok(jewelService.updateJewel(jewelId, jewelRequestDTO));
    }

    @DeleteMapping("/jewelry/delete/{jewelId}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long jewelId) {
        jewelService.deleteJewel(jewelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
