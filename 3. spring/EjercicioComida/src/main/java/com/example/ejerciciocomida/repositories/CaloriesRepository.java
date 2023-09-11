package com.example.ejerciciocomida.repositories;

import com.example.ejerciciocomida.entities.Dish;
import com.example.ejerciciocomida.entities.Ingredient;
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
public class CaloriesRepository implements ICaloriesRepository{

    private List<Ingredient> dataBase = new ArrayList<>();

    public CaloriesRepository(){
        this.dataBase = loadDataBase();
    }

    @Override
    public Integer getCalories(String name) {
        for (Ingredient ingredient: this.dataBase) {
            if(name.equals(ingredient.getName())){
                return ingredient.getCalories();
            }
        }
        return null;
    }

    private List<Ingredient> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return characters;
    }
}
