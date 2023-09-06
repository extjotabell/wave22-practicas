package com.mercadolibre.ejerciciocovid.controller;

import com.mercadolibre.ejerciciocovid.dto.PersonaDTO;
import com.mercadolibre.ejerciciocovid.dto.SintomaDTO;
import com.mercadolibre.ejerciciocovid.model.Persona;
import com.mercadolibre.ejerciciocovid.model.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EjercicioCovidController {

    private List<Sintoma> sintomas = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public EjercicioCovidController() {
        sintomas.add(new Sintoma(1, "Tos", 1));
        sintomas.add(new Sintoma(2, "PerdidaDeOlfato", 2));
        sintomas.add(new Sintoma(3, "DolorAbdominal", 1));
        personas.add(new Persona(1, "Rodrigo", "Perez", 61, sintomas));
        personas.add(new Persona(2, "Ernesto", "Farias", 70, sintomas));
        personas.add(new Persona(3, "Lucas", "Fock", 70, new ArrayList<>()));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> buscarSintomas() {
        return ResponseEntity.ok(sintomas.stream().map(s -> new SintomaDTO(s.getCodigo(), s.getNombre(), s.getNivelDeGravedad())).toList());
    }

    @GetMapping("/findSympton/{nombre}")
    public ResponseEntity<Integer> buscarSintoma(@PathVariable String nombre) {
        return ResponseEntity.ok(sintomas.stream().filter(s -> s.getNombre().equals(nombre)).findFirst().get().getNivelDeGravedad());
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> buscarPersonasDeRiesgo() {
        Sintoma tos = sintomas.get(0);
        Sintoma olfato = sintomas.get(1);
        return ResponseEntity.ok(personas.stream()
                .filter(p -> p.getEdad() > 60)
                .filter(p -> p.getSintomas().contains(tos) || p.getSintomas().contains(olfato))
                .map(p -> new PersonaDTO(p.getNombre(), p.getApellido()))
                .toList()
        );
    }
}
