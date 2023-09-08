package com.example.ejerciciocovid19.controller;
import java.util.Random;
import com.example.ejerciciocovid19.dtos.PersonasDeRiesgoDTO;
import com.example.ejerciciocovid19.dtos.SintomaDTO;
import com.example.ejerciciocovid19.models.Persona;
import com.example.ejerciciocovid19.models.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {
    ArrayList<Persona> personas = new ArrayList<Persona>() {{
        add(new Persona(1, "Juan", "Perez", 30));
        add(new Persona(2, "Maria", "Gomez", 70));
        add(new Persona(3, "Pedro", "Lopez", 40));
        add(new Persona(4, "Ana", "Rodriguez", 93));
        add(new Persona(5, "Carlos", "Martinez", 28));
    }};

    ArrayList<Sintoma> sintomas = new ArrayList<Sintoma>() {{
        add(new Sintoma("S1", "fiebre", 3));
        add(new Sintoma("S2", "tos", 2));
        add(new Sintoma("S3", "dolor de garganta", 2));
        add(new Sintoma("S4", "fatiga", 1));
        add(new Sintoma("S5", "dificultad para respirar", 3));
    }};

    @GetMapping("/findSymptom")
    public ResponseEntity<ArrayList<SintomaDTO>> getAllSymptoms(){
        ArrayList<SintomaDTO> listaSintomas = new ArrayList<>();
        for (Sintoma sintoma: this.sintomas) {
            SintomaDTO sintomaDTO = new SintomaDTO(sintoma.getNombre(), sintoma.getNivel_de_gravedad());
            listaSintomas.add(sintomaDTO);
        }
        return new ResponseEntity(listaSintomas, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<String> getSymptom(@PathVariable String nombre){
        Sintoma sintomaEncontrado = null;
        for (Sintoma sintoma : sintomas) {
            if (sintoma.getNombre().equals(nombre)) {
                sintomaEncontrado = sintoma;
            }
        }

        if (sintomaEncontrado == null){
            return new ResponseEntity("No se encontro el sintoma", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(sintomaEncontrado.getNivel_de_gravedad().toString(), HttpStatus.OK);
        }
    }


    @GetMapping("/findRiskPerson")
    public ResponseEntity findRiskPerson(){
        ArrayList<PersonasDeRiesgoDTO> listaDeRiesgo = new ArrayList<>();
        for (Persona persona: this.personas) {
            if(persona.getEdad() >= 60){
                ArrayList<Sintoma> sintomasDeLaPersona = new ArrayList<>();
                Random random = new Random();
                for (int i = 0; i < this.sintomas.size(); i++) {
                    if (random.nextBoolean()){
                        sintomasDeLaPersona.add(this.sintomas.get(i));
                    }
                }
                PersonasDeRiesgoDTO personaDeRiesgo = new PersonasDeRiesgoDTO(persona.getNombre()+" "+persona.getApellido(), persona.getEdad(),sintomasDeLaPersona);
                listaDeRiesgo.add(personaDeRiesgo);
            }
        }

        return new ResponseEntity(listaDeRiesgo, HttpStatus.OK);
    }
}
