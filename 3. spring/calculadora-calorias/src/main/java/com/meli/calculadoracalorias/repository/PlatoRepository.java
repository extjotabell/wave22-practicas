package com.meli.calculadoracalorias.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoracalorias.model.Ingredient;
import com.meli.calculadoracalorias.model.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepository implements IPlatoRepository{

    private List<Plato> platos;

    private List<Ingredient> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("resources/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;

        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return ingredients;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return this.loadDataBase();
    }

    @Override
    public List<Plato> getAllPlatos() {
        return this.platos;
    }

    @Override
    public Plato getPlato(String name, Double weight) {
        return this.platos.stream().filter(p -> p.getName().equals(name) && p.getWeight().equals(weight)).findFirst().get();
    }

    @Override
    public Plato createPlato(List<Ingredient> ingredients, String nombre, Double peso) {
        return null;
    }

    private Ingredient getIngrediente(String name){
        return loadDataBase().stream().filter(a -> a.getName().equals(name)).findFirst().get();
    }

    private void crearMenu(){
        List<Ingredient> ingredients = loadDataBase();
        Plato lasagna = new Plato("Lasagna",
                List.of(
                getIngrediente("Acelga"),
                getIngrediente("Tomates")),
                300.0);
        Plato patoALaNaranja = new Plato("Pato a la naranja",
                List.of(
                getIngrediente("Pato"),
                getIngrediente("Naranja")),
                300.0);
        Plato ciervo = new Plato("Ciervo",
                List.of(
                getIngrediente("Ciervo"),
                getIngrediente("Champiñón y otras setas")),
                300.0);
        this.platos.add(lasagna);
        this.platos.add(patoALaNaranja);
        this.platos.add(ciervo);
    }
}
