package com.calculadoraCalorias.CalculadoraCalorias.repository;

import com.calculadoraCalorias.CalculadoraCalorias.models.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriesRepositoryImp implements ICaloriesRepository{

    List<Food> database;

    public CaloriesRepositoryImp() {
        this.database = loadDataBase();
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


    @Override
    public Food ingredientsInDish(String name) {
        Optional<Food> first = database.stream().filter(ingredientDTO -> ingredientDTO.getName().equals(name)).findFirst();

        Food result = null;
        if (first.isPresent())
            result = first.get();
        return result;
    }


}
