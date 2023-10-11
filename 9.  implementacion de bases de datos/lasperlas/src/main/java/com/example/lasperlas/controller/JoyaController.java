package com.example.lasperlas.controller;

import com.example.lasperlas.dto.JoyaDto;
import com.example.lasperlas.service.IJoyaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/joya")
public class JoyaController {

    private IJoyaService joyaService;

    @PostMapping
    public ResponseEntity<JoyaDto> agregarJoya(@RequestBody @Validated JoyaDto joyaDto){
        return ResponseEntity.ok(joyaService.agregarJoya(joyaDto));
    }

    @PutMapping("/{joyaId}")
    public ResponseEntity<JoyaDto> updateJoya(@PathVariable Long joyaId,
                                              @RequestBody JoyaDto updatedJoyaDto){
        return ResponseEntity.ok(joyaService.updateJoya(joyaId, updatedJoyaDto));
    }

    @GetMapping
    public ResponseEntity<List<JoyaDto>> getJoyas(){
        return ResponseEntity.ok(joyaService.getJoyas());
    }

    @DeleteMapping
    public void borrarJoya(@RequestParam Long joyaId){
        joyaService.borrarJoya(joyaId);
    }
}
