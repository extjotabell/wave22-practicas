package com.example.ejerciciocalculadoracalorias2.repository;

import com.example.ejerciciocalculadoracalorias2.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredientRepository {

    private List<Ingredient> ingredients;

    public IngredientRepository() {
        this.ingredients = loadDataBase();
    }

    @Override
    public List<Ingredient> findAllIngredients() {
        return ingredients;
    }

    @Override
    public Ingredient findIngredientByName(String name) {
        return ingredients.stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }

    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }
}
