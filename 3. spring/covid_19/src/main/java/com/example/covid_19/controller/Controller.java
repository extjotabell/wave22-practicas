package com.example.covid_19.controller;

import com.example.covid_19.dto.GravedadDTO;
import com.example.covid_19.dto.SintomaDTO;
import com.example.covid_19.dto.SintomasDTO;
import com.example.covid_19.service.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private ServiceImpl service;

    public Controller(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> todosLosSintomas(){
        List<SintomaDTO> sintomas = service.getSintomas();
        return new ResponseEntity<>(sintomas, HttpStatus.FOUND);
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<GravedadDTO> obtenerGravedadSintoma(@PathVariable("name") String nombre_sintoma){
        SintomaDTO sintoma_buscado = new SintomaDTO();
        sintoma_buscado.setNombre(nombre_sintoma);
        GravedadDTO gravedad = service.obtenerGravedadSintoma(sintoma_buscado);
        return new ResponseEntity<>(gravedad, HttpStatus.FOUND);
    }

}
