package com.spring.covid19.web.controllers;

import com.spring.covid19.entities.Gravedad;
import com.spring.covid19.entities.Sintoma;
import com.spring.covid19.services.SintomaService;
import com.spring.covid19.web.dto.SintomaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/symptoms")
public class SintomaController {
    private final SintomaService sintomaService;

    public SintomaController(SintomaService sintomaService) {
        this.sintomaService = sintomaService;
    }

    @GetMapping("/findSymptom")
    public List<SintomaDTO> getSymptoms() {
        List<SintomaDTO> sintomas;
        sintomas = (sintomaService.findAllSintomas()).stream().map(
                sintoma -> {
                    String codigo = sintoma.getCodigo();
                    String nombre = sintoma.getNombre();
                    Gravedad gravedad = sintoma.getGravedad();
                    return new SintomaDTO(codigo, nombre, gravedad);
                }
        ).collect(Collectors.toList());
        return sintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> getSymptomByName(@PathVariable String name) {
        Sintoma s = sintomaService.findSintomaByName(name);
        SintomaDTO sDTO = new SintomaDTO(s.getCodigo(), s.getNombre(), s.getGravedad());
        return new ResponseEntity<>(sDTO, HttpStatus.OK);
    }
}
