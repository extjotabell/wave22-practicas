package com.example.ejercicio_deportistas.controller;

import com.example.ejercicio_deportistas.dto.DeporteDTO;
import com.example.ejercicio_deportistas.dto.DeportistaDTO;
import com.example.ejercicio_deportistas.model.Deporte;
import com.example.ejercicio_deportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DeporteController {

    List<Persona> listaPersonas = new ArrayList<>();
    List<Deporte> listaDeportes = new ArrayList<>();

    public DeporteController(){
        listaDeportes.add(new Deporte("Futbol", "Avanzado"));
        listaDeportes.add(new Deporte("Tenis", "Intermedio"));
        listaDeportes.add(new Deporte("Golf", "Intermedio"));
        listaDeportes.add(new Deporte("Ping pong", "Avanzado"));

        listaPersonas.add(new Persona("Facundo", "Hermida", 23));
        listaPersonas.add(new Persona("Martín", "López", 25));
        listaPersonas.add(new Persona("Carlos", "Fernández", 40));
        listaPersonas.add(new Persona("Martina", "Apellido", 35));
    }

    @GetMapping("/findSports")
    public List<DeporteDTO> findSports(){

        List<DeporteDTO> listaDeportesDTO = new ArrayList<>();

        for (Deporte listaDeporte : listaDeportes) {
            listaDeportesDTO.add(new DeporteDTO(listaDeporte.getNivel()));
        }

        return listaDeportesDTO;
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name){
        //Filtro la lista de deportes
        Optional<Deporte> deporte = listaDeportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst();

        //Creo el objeto DTO
        DeporteDTO deporteDTO = null;
        if(deporte.isPresent()){
            deporteDTO = new DeporteDTO(deporte.get().getNivel());
            return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> findSportsPersons() {

        List<DeportistaDTO> listaDeportistas = new ArrayList<>();

        //Mapa que asocia deportes con personas
        Map<Persona, Deporte> personaDeporteMap = new HashMap<>();

        for (int i = 0; i < listaDeportes.size(); i++) {
            personaDeporteMap.put(listaPersonas.get(i), listaDeportes.get(i));
        }

        //Ingreso los valores del map a la lista de deportistas
        for (Map.Entry<Persona, Deporte> set : personaDeporteMap.entrySet()){
            listaDeportistas.add(new DeportistaDTO(set.getKey().getNombre(), set.getKey().getApellido(), set.getValue().getNombre()));
        }

        return listaDeportistas;

    }





}
