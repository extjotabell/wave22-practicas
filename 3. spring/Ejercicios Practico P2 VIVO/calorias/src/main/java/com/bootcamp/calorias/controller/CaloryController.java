package com.bootcamp.calorias.controller;

import com.bootcamp.calorias.dto.InformeCaloricoDTO;
import com.bootcamp.calorias.service.CaloryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CaloryController {

    private final CaloryService caloryService;

    @GetMapping("/calcularCalorias/plato")
    public ResponseEntity<InformeCaloricoDTO> obtenerInformacionPorPlato(
            @RequestParam("nombre") String nombrePlato,
            @RequestParam int peso) {
        return ResponseEntity.ok(caloryService.obtenerInformeCalorico(nombrePlato, peso));
    }

}
