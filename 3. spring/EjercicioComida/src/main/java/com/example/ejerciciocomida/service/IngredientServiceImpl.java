package com.example.ejerciciocomida.service;

import com.example.ejerciciocomida.dto.IngredientDto;
import com.example.ejerciciocomida.entity.Ingredient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;

public class IngredientServiceImpl implements IngredientService{
    @Autowired

    @Override
    public List<IngredientDto> getIngredients() {
        return null;
    }

    private List<Ingredient> loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:ingredients.json");
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

        return characters;
    }

}
