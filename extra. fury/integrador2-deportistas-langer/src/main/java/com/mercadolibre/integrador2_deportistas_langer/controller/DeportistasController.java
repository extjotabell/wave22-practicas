package com.mercadolibre.integrador2_deportistas_langer.controller;

import com.mercadolibre.integrador2_deportistas_langer.dtos.DeporteDTO;
import com.mercadolibre.integrador2_deportistas_langer.dtos.DeportistaDTO;
import com.mercadolibre.integrador2_deportistas_langer.model.Deportee;
import com.mercadolibre.integrador2_deportistas_langer.model.Persona;
import com.mercadolibre.integrador2_deportistas_langer.repository.DeportesRepository;
import com.mercadolibre.integrador2_deportistas_langer.repository.PersonasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistasController {
    PersonasRepository pRepo = new PersonasRepository();
    DeportesRepository dRepo = new DeportesRepository();

    public DeportistasController() {
        // Esto no está bien, lo veremos mejor cuando aprendamos arquitectura multicapa
        Deportee deporte1 = new Deportee("Tenis", "Bajo");
        Deportee deporte2 = new Deportee("Futbol", "Alto");
        Deportee deporte3 = new Deportee("Arquería", "Alto");
        dRepo.agregarDeporte(deporte1);
        dRepo.agregarDeporte(deporte2);
        dRepo.agregarDeporte(deporte3);

        Persona persona1 = new Persona("Juan", "Lopez", 17);
        Persona persona2 = new Persona("Jose", "Lopez", 12);
        Persona persona3 = new Persona("Maria", "Lopez", 20);
        pRepo.agregarPersonaYSuDeporte(persona1, deporte1);
        pRepo.agregarPersonaYSuDeporte(persona2, deporte2);
        pRepo.agregarPersonaYSuDeporte(persona3, null);
    }

    @GetMapping("/findSports")
    public List<DeporteDTO> retornarDeportes(){
        DeportistasController controller = new DeportistasController();
        return controller.dRepo.getListaDeDeportesDTO();
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<String> existeDeporte(@PathVariable String name){
        DeporteDTO deporteDTO = new DeporteDTO(name, null);
        DeportistasController controller = new DeportistasController();
        return new ResponseEntity<>(controller.dRepo.getNivelDeDeporte(deporteDTO.getName()), HttpStatus.OK) ;
    }

    @GetMapping("/findSportsPersons") //Esto debería ser people, creo
    ResponseEntity<List<DeportistaDTO>> findSportPeople(){
        DeportistasController controller = new DeportistasController();
        List<DeportistaDTO> resultado = new ArrayList<>();
        for (Persona persona : pRepo.getDeportistas()){
            DeportistaDTO deportista = new DeportistaDTO(persona.getNombre(), persona.getApellido(), pRepo.getDeporteDePersona(persona).getNombre());
            resultado.add(deportista);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
}
