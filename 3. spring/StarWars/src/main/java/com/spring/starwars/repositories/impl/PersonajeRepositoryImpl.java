package com.spring.starwars.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.entities.Personaje;
import com.spring.starwars.repositories.IPersonajeRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    List<Personaje> personajes;

    public PersonajeRepositoryImpl() {
        this.personajes = loadDataBase();
    }
    @Override
    public List<Personaje> findPersonajesByWord(String word) {
        List<Personaje> result = new ArrayList<>();
        for (Personaje p : personajes) {
            if (p.getName().toLowerCase().contains(word.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    private List<Personaje> loadDataBase() {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};

        try {
            // Cargar el archivo JSON desde la carpeta resources
            Resource resource = new ClassPathResource("starwars.json");
            File file = resource.getFile();

            // Leer y deserializar el archivo JSON en una lista de Personaje
            List<Personaje> characters = objectMapper.readValue(file, typeRef);

            // Manejar la conversión de "mass" de String a int y establecer 0 si es "NA"
            for (Personaje character : characters) {
                String massStr = String.valueOf(character.getMass());
                // Manejo de casos donde "mass" es "NA" o tiene comas
                if ("NA".equals(massStr)) {
                    character.setMass(0);
                } else if (!massStr.isEmpty()) {
                    massStr = massStr.replaceAll(",", ""); // Eliminar comas
                    Integer mass = Integer.valueOf(massStr);
                    character.setMass(mass);
                }
            }

            System.out.println("Database loading successfully...");
            return characters;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}



