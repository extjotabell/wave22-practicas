package com.personaje.personajedisney.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personaje.personajedisney.Dto.PersonajeDto;
import com.personaje.personajedisney.Interface.IPersonajeRepository;
import com.personaje.personajedisney.Models.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class PersonajeRepository implements IPersonajeRepository {

    private final List<Personaje> database;

    public PersonajeRepository() {
        this.database = loadDataBase();
    }
    @Override
    public List<Personaje> GetPersonaje(String name) {

        return this.database.stream().filter(personaje -> personaje.getName().contains(name)).collect(Collectors.toList());
    }
    private List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }


}
