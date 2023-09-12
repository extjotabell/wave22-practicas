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
import java.util.Arrays;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository{

    List<Dish> dataBase = new ArrayList<>();

    public DishRepository() {
         this.dataBase.add(new Dish("Pizza", 200, Arrays.asList(new Ingredient("Queso mozzarella"), new Ingredient("Aceitunas verdes"))));
         this.dataBase.add(new Dish("Ensalada", 200, Arrays.asList(new Ingredient("Lechuga"), new Ingredient("Tomates"))));
         this.dataBase.add(new Dish("Hamburgesa", 200, Arrays.asList(new Ingredient("Hamburguesa"), new Ingredient("Pan de trigo blanco"))));
    }


    @Override
    public List<Ingredient> getIngredients(String name) {
        List<Ingredient> ingredientes = new ArrayList<>();
        for (Dish dish: this.dataBase) {
            if(name.equals(dish.getName())){
                for(Ingredient ingredient: dish.getIngredients()){
                    ingredientes.add(ingredient);
                }
                return ingredientes;
            }
        }
        return ingredientes;
    }

    @Override
    public Dish getDish(String name) {
        for (Dish dish: this.dataBase) {
            if (name.equals(dish.getName())){
                return dish;
            }
        }
        return null;
    }

    @Override
    public List<Dish> getAllDishes() {
        return this.dataBase;
    }

    private List<Dish> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:dishes.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Dish>> typeRef = new TypeReference<>() {};
        List<Dish> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return characters;
    }
}
