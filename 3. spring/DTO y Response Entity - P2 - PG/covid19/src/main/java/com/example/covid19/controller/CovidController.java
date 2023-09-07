package com.example.covid19.controller;

import com.example.covid19.dto.RiskPerson;
import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CovidController {

    List<Sintoma> sintomas = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    public CovidController() {
        sintomas.add(new Sintoma("adsa", "tos", "alto"));
        sintomas.add(new Sintoma("gdfg", "fiebre", "medio"));
        sintomas.add(new Sintoma("dfg", "dolor corporal", "bajo"));

        personas.add(new Persona(1, "randy", "Mendoza", 30, sintomas));
        personas.add(new Persona(1, "maria", "rodriguez", 61, sintomas));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getAllSymptom() {
        List<SintomaDTO> sintomasDTO =
                sintomas
                        .stream()
                        .map(sintoma -> new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelSeguridad()))
                        .toList();
        return ResponseEntity.ok(sintomasDTO);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getAllSymptomByName(@PathVariable("name") String symptomName) {
        Optional<Sintoma> sintoma = sintomas.stream()
                .filter(s -> s.getNombre().equals(symptomName))
                .findFirst();

        return sintoma.map(s -> ResponseEntity.ok(s.getNivelSeguridad())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPerson>> getAllRiskPersons() {
        List<RiskPerson> riskPersons = personas.stream()
                .filter(p -> p.getEdad() > 60)
                .map(persona -> new RiskPerson(persona.getNombre(), persona.getApellido())).toList();
        return ResponseEntity.ok(riskPersons);
    }
}
