package com.calculadoraDeCalorias.calculadoraDeCalorias.repository;

import com.calculadoraDeCalorias.calculadoraDeCalorias.entity.Dish;
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
public class RepositoryCalculadora implements IRepositoryCalculadora{

    List<Dish> dishesDB;

    public RepositoryCalculadora() {
        loadDataBase();
    }

    @Override
    public void loadDataBase() {
        File dishesFile = null;

        try {
            dishesFile = ResourceUtils.getFile("classpath:food.json");
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Dish>> dishesTypeRef = new TypeReference<>() {};

        try {
            List<Dish> dishes = objectMapper.readValue(dishesFile, dishesTypeRef);

            System.out.println("Database load successfully!");
            dishesDB = dishes;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Dish> getAllDishes() {
        System.out.println(dishesDB);
        return dishesDB;
    }
}
