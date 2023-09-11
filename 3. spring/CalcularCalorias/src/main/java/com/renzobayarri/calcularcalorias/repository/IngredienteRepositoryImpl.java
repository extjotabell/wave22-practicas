package com.renzobayarri.calcularcalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renzobayarri.calcularcalorias.model.Ingrediente;
import com.renzobayarri.calcularcalorias.model.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteRepositoryImpl implements IngredienteRepository{

    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImpl() throws IOException {
        ingredientes = loadDatabase();
    }

    private List<Ingrediente> loadDatabase() throws IOException {

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        ClassPathResource classPathResource = new ClassPathResource("food.json");
//        InputStream inputStream = classPathResource.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<>() {
        });
    }



    public Ingrediente findIngredienteByName(String name){
        return ingredientes.stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }
}
