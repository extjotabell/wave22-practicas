package com.example.ejerciciopersonajessw.repository;

import com.example.ejerciciopersonajessw.entity.Caracter;
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
public class CaracterRepository implements ICaracaterRepository{

    List<Caracter> dataBaseFromJson;

    public CaracterRepository() {
        this.dataBaseFromJson = loadDataBase();
    }

    @Override
    public List<Caracter> searchByName(String name) {
        List<Caracter> caractersByName = new ArrayList<>();
        for (Caracter caracter : this.dataBaseFromJson) {
            if(caracter.getName().contains(name)){
                caractersByName.add(caracter);
            }
        }
        return caractersByName;
    }

    private List<Caracter> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Caracter>> typeRef = new TypeReference<>() {};
        List<Caracter> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return characters;
    }

}
