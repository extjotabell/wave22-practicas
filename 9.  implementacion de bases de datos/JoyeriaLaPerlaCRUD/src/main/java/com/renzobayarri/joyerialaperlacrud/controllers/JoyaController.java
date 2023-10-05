package com.renzobayarri.joyerialaperlacrud.controllers;

import com.renzobayarri.joyerialaperlacrud.dto.JoyaDTO;
import com.renzobayarri.joyerialaperlacrud.services.JoyaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/jewerly")
public class JoyaController {

    private JoyaService joyaService;

    @GetMapping
    public ResponseEntity<List<JoyaDTO>> findAllRegistered() {
        return ResponseEntity.ok(joyaService.findAll());
    }

    @PostMapping("/new")
    public ResponseEntity<JoyaDTO> save(@RequestBody @Valid JoyaDTO joya) {
        return new ResponseEntity<>(joyaService.save(joya), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaDTO> update(@RequestBody @Valid JoyaDTO joya,
                                          @PathVariable Long id) {
        return new ResponseEntity<>(joyaService.update(joya, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        joyaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
