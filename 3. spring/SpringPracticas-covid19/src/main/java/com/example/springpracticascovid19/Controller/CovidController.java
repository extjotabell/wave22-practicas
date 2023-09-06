package com.example.springpracticascovid19.Controller;

import com.example.springpracticascovid19.Models.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class CovidController {

    private List<Sintoma> sintomas;

    @GetMapping("/findSymptom")
    public List<Sintoma> GetAllSintomas(){

        return sintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Integer> GetSintoma(@PathVariable String name){

        Optional<Sintoma> nuevalista = sintomas.stream()
                .filter(x -> x.getNombre().equals(name))
                .findFirst();

        Sintoma sintomaEncontrado = nuevalista.orElse(null);

        assert sintomaEncontrado != null;

        return new ResponseEntity<>(sintomaEncontrado.getNivelGravedad(), HttpStatus.OK);
    }
}
