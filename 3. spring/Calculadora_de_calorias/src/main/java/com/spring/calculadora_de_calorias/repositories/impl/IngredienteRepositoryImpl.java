package com.spring.calculadora_de_calorias.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calculadora_de_calorias.entities.Ingrediente;
import com.spring.calculadora_de_calorias.entities.Plato;
import com.spring.calculadora_de_calorias.repositories.IIngredienteRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository {

    List<Ingrediente> ingredientes;
    List<Plato> platos;

    @Override
    public Map<Ingrediente, Double> getAllIngredientesAndCalories(String nombrePlato) {
        Map<Ingrediente, Double> ingredientesYCalorias = new HashMap<>();
        Plato plato = buscarPlatoPorNombre(nombrePlato);
        if (plato != null) {
            List<Ingrediente> listaIngredientes = plato.getIngredientes();

            for (Ingrediente ingrediente : listaIngredientes) {
                double calorias = calcularCalorias(plato);
                ingredientesYCalorias.put(ingrediente, calorias);
            }
        }
        return ingredientesYCalorias;
    }

    @Override
    public Ingrediente getIngredientWithMaxCalories(String nombrePlato) {
        Plato platoEncontrado = buscarPlatoPorNombre(nombrePlato);
        Ingrediente ingredienteMaxCalories = platoEncontrado.getIngredientes().get(0);
        for (Ingrediente i: platoEncontrado.getIngredientes()) {
            if(i.getCalories() > ingredienteMaxCalories.getCalories()) {
                ingredienteMaxCalories = i;
                ingredienteMaxCalories.setNombre(i.getNombre());
            }
        }
        return ingredienteMaxCalories;
    }

    public IngredienteRepositoryImpl() {
        this.ingredientes = loadDataBaseIngredientes();
        this.platos = loadDataBasePlatos();
    }

    private List<Ingrediente> loadDataBaseIngredientes() {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {
        };

        try {
            // Cargar el archivo JSON desde la carpeta resources
            Resource resource = new ClassPathResource("food.json");
            File file = resource.getFile();

            // Leer y deserializar el archivo JSON en una lista de Ingrediente
            List<Ingrediente> characters = objectMapper.readValue(file, typeRef);

            System.out.println("Database of ingredientes loading successfully...");
            return characters;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Plato> loadDataBasePlatos() {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeReference<List<Plato>> typeRef = new TypeReference<>() {
        };
        try {
            // Cargar el archivo JSON desde la carpeta resources
            Resource resource = new ClassPathResource("dish.json");
            File file = resource.getFile();

            // Leer y deserializar el archivo JSON en una lista de Ingrediente
            List<Plato> characters = objectMapper.readValue(file, typeRef);

            System.out.println("Database of dishes loading successfully...");
            return characters;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Plato buscarPlatoPorNombre(String nombre) {
        Plato platoEncontrado = null;
        for (Plato plato: platos) {
            if(Objects.equals(plato.getName(), nombre)) {
                platoEncontrado = plato;
            }
        }
        return platoEncontrado;
    }

    private double calcularCalorias(Plato plato) {
        // Implementa la lógica para calcular las calorías en base al ingrediente y al peso
        // Devuelve la cantidad de calorías calculadas
        double caloriasTotalesPlato = 0;
        for (Plato p: platos) {
            if(p == plato) {
                for (Ingrediente ingrediente : p.getIngredientes()) {
                    caloriasTotalesPlato += ingrediente.getCalories();
                }
            }
        }
        return caloriasTotalesPlato;
    }

}
