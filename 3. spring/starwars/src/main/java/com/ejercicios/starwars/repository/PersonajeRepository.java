package com.ejercicios.starwars.repository;

import com.ejercicios.starwars.dto.PersonajeDTO;
import com.ejercicios.starwars.entity.Personaje;
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
public class PersonajeRepository implements IRepository{

    List<Personaje> dataBase;

     public PersonajeRepository(){
         this.dataBase = loadDataBase();
     }
    @Override
    public List<Personaje> getAll() {
        return this.dataBase;
    }

    @Override
    public List<Personaje> findByName(String name) {
        List<Personaje> resultados = new ArrayList<>();

        for (Personaje personaje : this.dataBase) {
            if (personaje.getName().toLowerCase().contains(name.toLowerCase())) {
                resultados.add(personaje);
            }
        }

        return resultados;
    }

    @Override
    public void save(Personaje personajeDTO) {
         dataBase.add(personajeDTO);
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
