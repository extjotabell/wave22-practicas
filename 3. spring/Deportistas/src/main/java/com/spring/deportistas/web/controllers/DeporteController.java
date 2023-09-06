package com.spring.deportistas.web.controllers;

import com.spring.deportistas.entities.Deporte;
import com.spring.deportistas.services.DeporteService;
import com.spring.deportistas.web.dto.DeporteDTO;
import com.spring.deportistas.web.dto.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sports")
public class DeporteController {
        private final DeporteService deporteService;

    public DeporteController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("/findSports")
        public List<Deporte> getSportsPersons() {
            return deporteService.findSports();
    }


    @GetMapping("/findSport/{name}")
    ResponseEntity<DeporteDTO> getSportByName(@PathVariable String name) {
        DeporteDTO deporteDTO = new DeporteDTO();
        Deporte deportePorNombre = deporteService.findSportByName(name);
        deporteDTO.setNombre(deportePorNombre.getNombre());
        deporteDTO.setNivel(deportePorNombre.getNivel());
        return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
    }
}
