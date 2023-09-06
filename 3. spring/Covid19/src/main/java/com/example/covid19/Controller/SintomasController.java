package com.example.covid19.Controller;

import com.example.covid19.Model.Sintoma;
import com.example.covid19.Repository.SintomasRepository;
import com.example.covid19.Service.PersonasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("findSymptopm")
public class SintomasController {

    private final SintomasRepository sintomasRepository = new SintomasRepository();

    @GetMapping
    public ResponseEntity<List<Sintoma>> getAllSintomas(){
       return new ResponseEntity<>(sintomasRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Sintoma> getSintomaByName(@PathVariable String name){
        return new ResponseEntity<>(sintomasRepository.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSintoma(@RequestBody Sintoma sintoma){
        this.sintomasRepository.add(sintoma);
        return new ResponseEntity<>("Sintoma agregado: " + sintoma.getNombre(), HttpStatus.OK);
    }
}
