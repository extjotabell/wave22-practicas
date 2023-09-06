package com.example.ejerciciodeportes.controller;
import com.example.ejerciciodeportes.dtos.DeporteDto;
import com.example.ejerciciodeportes.dtos.DeporteNivelDto;
import com.example.ejerciciodeportes.dtos.DeportistaDto;
import com.example.ejerciciodeportes.entidades.Deporte;
import com.example.ejerciciodeportes.entidades.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@RestController
public class DeporteController {
    private ArrayList<Deporte> listaDeportes = new ArrayList<Deporte>() {{
        add(new Deporte("Fútbol", 5));
        add(new Deporte("Baloncesto", 4));
        add(new Deporte("Tenis", 3));
        add(new Deporte("Natación", 2));
        add(new Deporte("Atletismo", 1));
    }};

    private ArrayList<Persona> listaPersonas = new ArrayList<Persona>() {{
        add(new Persona("Juan", "Pérez", 30));
        add(new Persona("María", "Gómez", 25));
        add(new Persona("Carlos", "López", 35));
        add(new Persona("Laura", "Martínez", 28));
        add(new Persona("Pedro", "Sánchez", 40));
    }};


    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<DeporteDto>> GetAllDeportes(){
        ArrayList<DeporteDto> response = new ArrayList<>();

        for (Deporte deporte: this.listaDeportes) {
            response.add(new DeporteDto(deporte.getNombre(), deporte.getNivel()));
        }


        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteNivelDto> GetDevuelveDeporte(@PathVariable String name){

        Optional<Deporte> nuevalista = listaDeportes.stream()
                .filter(x -> x.getNombre().equals(name))
                .findFirst();

        Deporte deporteEncontrado = nuevalista.orElse(null);
        DeporteNivelDto response = new DeporteNivelDto(deporteEncontrado.getNivel());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<ArrayList<DeportistaDto>> GetAllPersonasDeportistas(){

        Random random = new Random();
        ArrayList<DeportistaDto> listaDeportistas = new ArrayList<>();

        for (Persona persona: this.listaPersonas) {
            if(random.nextBoolean()){
                int numeroAleatorioDeporte = random.nextInt(5);
                DeportistaDto deportista = new DeportistaDto(persona.getNombre(), persona.getApellido(), this.listaDeportes.get(numeroAleatorioDeporte).getNombre());
                listaDeportistas.add(deportista);
            }
        }

        return new ResponseEntity<>(listaDeportistas, HttpStatus.OK);
    }

}
