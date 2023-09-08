package com.example.ejerciciocomida.repository;

import com.example.ejerciciocomida.entity.Food;
import com.example.ejerciciocomida.entity.Ingredient;
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

public class IngredientsRepositoryImpl {
    List<Ingredient> ingredients = new ArrayList<>();

    public IngredientRepositoryImpl(){
        this.ingredients = loadDataBase();
    }

    @Override
    public List<Ingredient> getIngredients(){
        return ingredients;
    }


    private List<Ingredient> loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Food> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
