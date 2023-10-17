package com.meli.joyeria.controller;

import com.meli.joyeria.dto.JoyaDTO;
import com.meli.joyeria.service.IJoyeriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyeriaController {
    private final IJoyeriaService joyeriaService;

    public JoyeriaController(IJoyeriaService joyeriaService){
        this.joyeriaService = joyeriaService;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> crear(@RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyeriaService.crearJoya(joyaDTO));
    }

    @GetMapping("/jewerly")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(joyeriaService.listar());
    }

    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> softDelete(@PathVariable Long id){
        return ResponseEntity.ok(joyeriaService.softDelete(id));
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<?> update(@RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyeriaService.update(joyaDTO));
    }

}
