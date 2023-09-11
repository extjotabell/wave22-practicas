package com.restaurant.calories.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.calories.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredientRepository {
    List<Ingredient> dataBase;

    public List<Ingredient> getAllEstudiantes() {
        return this.dataBase;
    }
    private List<Ingredient> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:estudiantes.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;

        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return ingredients;
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return dataBase.stream().anyMatch(x->x.getName().equals(name)) ?
                dataBase.stream().filter(x->x.getName().equals(name)).findFirst().get() : null;
    }
}
