package com.example.covid19.controller;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import com.example.covid19.repository.impl.PersonaCRUDImpl;
import com.example.covid19.repository.impl.SintomaCRUDImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SymptomController {

    PersonaCRUDImpl personaCRUD = new PersonaCRUDImpl();
    SintomaCRUDImpl sintomaCRUD = SintomaCRUDImpl.getInstance();

    @GetMapping("/findSymptoms")
    public List<SintomaDTO> findSymptoms(){
        List<Sintoma> listaSintomas = sintomaCRUD.findSymptoms();
        List<SintomaDTO> listaSintomasDTO = new ArrayList<>();
        for(Sintoma s : listaSintomas){
            listaSintomasDTO.add(new SintomaDTO(s.getNombre(), s.getNivelGravedad()));
        }
        return listaSintomasDTO;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Optional<SintomaDTO>> findSymptom(@PathVariable String name){
        Optional<Sintoma> sintoma = sintomaCRUD.findSymptom(name);
        SintomaDTO sintomaDTO = null;
        if(sintoma.isPresent()){
            sintomaDTO = new SintomaDTO(sintoma.get().getNombre(), sintoma.get().getNivelGravedad());
        }
        return new ResponseEntity<>(Optional.ofNullable(sintomaDTO), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findRiskPerson(){
        List<Persona> listaPersonasFiltrada = personaCRUD.findRiskPerson();
        List<PersonaDTO> listaPersonasDTO = new ArrayList<>();
        for(Persona p : listaPersonasFiltrada){
            listaPersonasDTO.add(new PersonaDTO(p.getNombre(), p.getApellido()));
        }
        return listaPersonasDTO;
    }

    @PostMapping("/save_person")
    public void savePerson(@RequestBody Persona persona){
        personaCRUD.save(persona);
    }
}
