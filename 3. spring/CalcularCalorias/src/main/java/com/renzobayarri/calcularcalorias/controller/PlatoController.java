package com.renzobayarri.calcularcalorias.controller;

import com.renzobayarri.calcularcalorias.dto.PlatoDTO;
import com.renzobayarri.calcularcalorias.service.PlatoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlatoController {

    private PlatoService platoService;

    @GetMapping("/{nombrePlato}/{peso}")
    public ResponseEntity<PlatoDTO> getInfoPlato(@PathVariable String nombrePlato, @PathVariable int peso) {
        return ResponseEntity.ok(platoService.getInfoPlatoByName(nombrePlato, peso));
    }

    @GetMapping("/")
    public ResponseEntity<List<PlatoDTO>> getInfoPlatos() {
        return ResponseEntity.ok(platoService.getInfoPlatos());
    }

}
