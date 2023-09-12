package com.bootcamp.calorias.controller;

import com.bootcamp.calorias.dto.InformeCaloricoDTO;
import com.bootcamp.calorias.service.CaloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloryController {

    @Autowired
    CaloryService caloryService;

    @GetMapping("/calcularCalorias/plato/{plato}/gramaje/{gramaje}")
    public ResponseEntity<InformeCaloricoDTO> respuestaAQuery(String plato, int gramaje){
        return new ResponseEntity<>(caloryService.obtenerInformeCalorico(plato, gramaje), HttpStatus.OK) ;
    }

}
