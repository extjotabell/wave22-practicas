package com.bootcamp.Caloriass.controller;

import com.bootcamp.Caloriass.service.CaloryService;
import com.bootcamp.Caloriass.dto.InformeCaloricoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloryController {

    @Autowired
    CaloryService caloryService;

    @GetMapping("calcularCalorias/plato/{plato}/gramaje/{gramaje}")
    public ResponseEntity<InformeCaloricoDTO> respuestaAQuery(@PathVariable String plato, @PathVariable Integer gramaje){
        return new ResponseEntity<>(caloryService.obtenerInformeCalorico(plato, gramaje), HttpStatus.OK) ;
    }

}
