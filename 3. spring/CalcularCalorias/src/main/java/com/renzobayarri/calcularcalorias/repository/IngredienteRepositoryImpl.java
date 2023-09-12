package com.renzobayarri.calcularcalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renzobayarri.calcularcalorias.model.Ingrediente;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository {

    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImpl() throws IOException {
        ingredientes = loadDatabase();
    }

    private List<Ingrediente> loadDatabase() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("food.json");
        InputStream inputStream = classPathResource.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputStream, new TypeReference<>() {
        });
    }


    public Ingrediente findIngredienteByName(String name) {
        return ingredientes.stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }
}
