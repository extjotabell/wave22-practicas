package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Food;
import com.example.calculadoracalorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FoodRepoIMP implements IRepo<Food,String> {

    List<Food> dataBase;

    public FoodRepoIMP() {
        this.dataBase = loadDataBase();
    }

    @Override
    public List<Food> getAll() {
        return this.dataBase;
    }

    @Override
    public Food getByName(String name) {

        return dataBase.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private List<Food> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Food>> typeRef = new TypeReference<>() {};
        List<Food> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return characters;
    }


}
