package com.example.demoDTO.controller;

import com.example.demoDTO.dto.DeporteDto;
import com.example.demoDTO.dto.PersonaDto;
import com.example.demoDTO.model.Deporte;
import com.example.demoDTO.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controlador {
    List<Deporte> deportes = new ArrayList<>();

    Deporte deporte1 = new Deporte("Futbol", "Avanzado");
    Deporte deporte2 = new Deporte("Basquetball", "Principiante");
    Deporte deporte3 = new Deporte("Natacion", "Medio");

    Persona persona1 = new Persona("Lucas", "Espinosa", 23);
    Persona persona2 = new Persona("Daniel", "Ferreira", 23, "Futbol", "Avanzado");
    Persona persona3 = new Persona("Pedro", "Ramirez", 21, "Basquet", "SoyBuenardo");

    List<Persona> personas = new ArrayList<>();
    public controlador(){
        deportes.add(deporte1);
        deportes.add(deporte2);
        deportes.add(deporte3);

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
    }

    @GetMapping("/findDeportistas")
    public ResponseEntity<List<PersonaDto>> obtenerPersonasDeportistas(){

        try{
            List<PersonaDto> listResponse = new ArrayList<>();
            for (PersonaDto personas: convertirPersonaADto(personas)){
                if(personas.getDeporteDto()!=null){
                    listResponse.add(personas);
                }
            }
            return ResponseEntity.ok((listResponse));
        } catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/findPersona")
    public ResponseEntity<List<PersonaDto>> obtenerPersonas(){
            return ResponseEntity.ok(convertirPersonaADto(personas));
    }

    private List<PersonaDto> convertirPersonaADto(List<Persona> listPersonas){
        List<PersonaDto> listResponse = new ArrayList<>();
        for(Persona misPersonas: listPersonas){
            PersonaDto newDto = new PersonaDto(
                    misPersonas.getNombre(),
                    misPersonas.getApellido(),
                    misPersonas.getEdad());
            if(misPersonas.getDeporte()!=null){
                newDto.setDeporteDto(convertirAunDto(misPersonas.getDeporte()));
            }
            listResponse.add(newDto);
        }
        return listResponse;
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> obtenerDeportePorNombre(@PathVariable String name){
        try
        {
            for(Deporte deportes: deportes){
                if(deportes.getNombre().equals(name)){
                    return ResponseEntity.ok(convertirAunDto(deportes));
                }
            }
            return ResponseEntity.notFound().build();

        }
        catch(Exception e)
        {
            System.out.println("El nombre del deporte lanzo una excepcion: " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    private DeporteDto convertirAunDto(Deporte deporte){
        DeporteDto deporteDtoNuevo = new DeporteDto(deporte);
        return deporteDtoNuevo;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> obtenerDeportes(){

        return ResponseEntity.ok(convertirADto(deportes));
        // lo q va dentro del ok es lo q va a enviar como cuerpo

    }
    private List<DeporteDto> convertirADto(List<Deporte> deportes) {
        try{
            List<DeporteDto> deportesDto = new ArrayList<>();
            for (Deporte deporte : deportes) {
                DeporteDto deporteDTO =  new DeporteDto(deporte);
                deportesDto.add(deporteDTO);
            }
            return deportesDto;
        }
        catch (Exception e){
            System.out.println("error al serializar los deportes : " + e.getMessage());
        }
        return null;
    }

}
