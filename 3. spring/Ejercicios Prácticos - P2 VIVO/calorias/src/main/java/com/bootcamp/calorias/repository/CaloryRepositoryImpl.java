package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingrediente;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CaloryRepositoryImpl implements CaloryRepository {

    List<Ingrediente> ingredientes;

    public CaloryRepositoryImpl(){
        this.ingredientes = loadDataBase();
    }

    @Override
    public List<Ingrediente> obtenerTodosIngredientes() {
        return this.ingredientes;
    }

    @Override
    public Ingrediente obtenerIngredientePorNombre(String name) {
        return this.ingredientes.stream().filter(ingredient -> ingredient.getNombre().equalsIgnoreCase(name)).findFirst().get();
    }

    private List<Ingrediente> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredients = null;

        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return ingredients;
    }
}
