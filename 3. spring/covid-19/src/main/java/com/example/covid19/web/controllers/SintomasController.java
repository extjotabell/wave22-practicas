package com.example.covid19.web.controllers;

import com.example.covid19.models.Sintoma;
import com.example.covid19.services.PersonaService;
import com.example.covid19.services.SintomaServices;
import com.example.covid19.services.SintomaServicesImp;
import com.example.covid19.web.dto.PersonaDTO;
import com.example.covid19.web.dto.SintomaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.covid19.models.Sintoma;

import java.util.List;

@RestController
@RequestMapping("/api/sintomas")
public class SintomasController {

    private final SintomaServices sintomaService;

    public SintomasController(SintomaServices sintomaService) {
        this.sintomaService = sintomaService;
    }

    @GetMapping("/findSymptom")
    public List<SintomaDTO> findSymptom() {
        return sintomaService.findSymptom() ;
    }

    @GetMapping("/findSymptom/{name}")
    ResponseEntity<SintomaDTO> findSymptomByName(@PathVariable String name) {
        Sintoma sintomaPorNombre = sintomaService.findSymptomByName(name);
        SintomaDTO sintomaDTO = new SintomaDTO(sintomaPorNombre.getNombre(), sintomaPorNombre.getNivel_de_gravedad());
        return new ResponseEntity<>(sintomaDTO, HttpStatus.OK);
    }

}
