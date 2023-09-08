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

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository{

    private List<Personaje> personajes = new ArrayList<>();

    public StarWarsRepositoryImpl(){
        this.personajes = loadDataBase();
    }

    @Override
    public List<Personaje> getAllByName(String name) {
        return personajes.stream()
                .filter(persona -> persona.getName().contains(new StringBuilder(name)))
                .toList();
    }

    @Override
    public List<Personaje> getAll() {
        return personajes;
    }

    private List<Personaje> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return characters;
    }
}
