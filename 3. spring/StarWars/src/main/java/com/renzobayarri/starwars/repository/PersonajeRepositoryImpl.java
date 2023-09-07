package com.renzobayarri.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renzobayarri.starwars.model.Personaje;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {

    private List<Personaje> personajes;

    public PersonajeRepositoryImpl() throws Exception {
        try {
            personajes = loadPersonajes();
        } catch (IOException e) {
            throw new Exception("Error en la carga del archivo");
        }
    }

    private List<Personaje> loadPersonajes() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("starwars.json");
        InputStream inputStream = classPathResource.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, new TypeReference<>() {
        });
    }

    @Override
    public List<Personaje> getAll() {
        return personajes;
    }

    @Override
    public List<Personaje> getByName(String name) {
        return personajes.stream().filter(p -> p.getName().contains(name)).toList();
    }
}
