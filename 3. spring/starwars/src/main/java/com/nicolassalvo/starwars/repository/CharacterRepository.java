package com.nicolassalvo.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicolassalvo.starwars.model.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepository implements ICharacterRepository{
    List<Character> dataBase;

    public CharacterRepository() {
        this.dataBase = loadDataBase();
    }
    @Override
    public List<Character> getAllCharacters() {
        return this.dataBase;
    }

    @Override
    public List<Character> getCharactersByName(String name) {
        return null;
    }

    private List<Character> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Character>> typeRef = new TypeReference<>() {};
        List<Character> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return characters;
    }
}
