package com.example.starwars.repository;

import com.example.starwars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{

    List<Personaje> listaPersonajes = new ArrayList<>();

    public PersonajeRepositoryImpl(){
        listaPersonajes = leerJSON();
    }

    @Override
    public List<Personaje> getAll() {
        return listaPersonajes;
    }

    @Override
    public List<Personaje> getPersonajes(String name) {
        return listaPersonajes.stream().filter(personaje -> personaje.getName().contains(name))
                .collect(Collectors.toList());
    }

    private List<Personaje> leerJSON(){
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:personajes.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo JSON cargado...");
        return characters;
    }

}
