package com.starWars.StarWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starWars.StarWars.models.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository{

    private final List<Character> dataBase;

    public CharacterRepository() {this.dataBase = loadDataBase();}
    @Override
    public List<Character> findCharacter(String name) {
        return dataBase.stream().filter(c -> matchWith(name,c)).collect(Collectors.toList());
    }

    private boolean matchWith(String name, Character character) {
        return character.getName().toUpperCase().contains(name.toUpperCase());
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
