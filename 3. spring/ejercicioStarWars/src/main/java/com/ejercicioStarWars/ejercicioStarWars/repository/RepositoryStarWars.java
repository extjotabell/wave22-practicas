package com.ejercicioStarWars.ejercicioStarWars.repository;

import com.ejercicioStarWars.ejercicioStarWars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class RepositoryStarWars implements IRepositoryStarWars {

    private List<Personaje> personajesDB;

    public RepositoryStarWars() {
        loadDataBase();
    }

    @Override
    public void loadDataBase() {
        File personajesFile = null;

        try {
            personajesFile = ResourceUtils.getFile("classpath:starwars.json");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Personaje>> personajesTypeRef = new TypeReference<>() {};

        try {
            List<Personaje> personajes = objectMapper.readValue(personajesFile, personajesTypeRef);

            System.out.println("Database load successfully!");
            personajesDB = personajes;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> getAllPersonajes() {
        return personajesDB;
    }
}
