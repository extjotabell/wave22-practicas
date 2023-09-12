package com.deportista.deportista.Controller;

import com.deportista.deportista.DTO.DeporteDTO;
import com.deportista.deportista.DTO.PersonaDTO;
import com.deportista.deportista.Models.Deporte;
import com.deportista.deportista.Service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Sports")
public class DeportistasController {

    @Autowired
    IPersonaService service;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> GetAllSport(){
        return ResponseEntity.ok(service.GetAllDeporte());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> GetSport(@PathVariable String name){
        return ResponseEntity.ok(service.GetByNameDeporte(name));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> GetPersona(){
        return ResponseEntity.ok(service.GetPersona());
    }
}
