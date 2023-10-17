package com.example.compras.controller;

import com.example.compras.dto.CompraDTO;
import com.example.compras.model.Compra;
import com.example.compras.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/crear")
    public ResponseEntity<CompraDTO> crearCompra(@RequestBody CompraDTO compra) {
        return ResponseEntity.ok(compraService.createCompra(compra));
    }
}
