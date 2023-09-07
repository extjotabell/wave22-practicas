package com.mercadolibre.ejerciciopersonajes.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.ejerciciopersonajes.model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
public class PersonajeRepository implements IPersonajeRepository {

    List<Personaje> personajesDataBase;

    public PersonajeRepository() {
        this.personajesDataBase = loadDataBase();
    }

    @Override
    public List<Personaje> getAllPersonajesByName(String name) {
        return personajesDataBase.stream().filter(p -> p.getName().contains(name)).toList();
    }

    @Override
    public List<Personaje> getAllPersonajes() {
        return this.personajesDataBase;
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
