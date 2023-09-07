package com.startWars.startWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.startWars.startWars.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository {

    List<Personaje> dataBase;

    public PersonajeRepository() {
        this.dataBase = loadDataBase();
    }
    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        Pattern pattern = Pattern.compile(nombre, Pattern.CASE_INSENSITIVE);
        return dataBase.stream()
                .filter(personaje -> pattern.matcher(personaje.getName()).find())
                .collect(Collectors.toList());


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
