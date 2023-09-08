package com.example.springpracticascalcucolorias.repository;

import com.example.springpracticascalcucolorias.dto.GetPlatoDto;
import com.example.springpracticascalcucolorias.model.Ingrediente;
import com.example.springpracticascalcucolorias.model.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class PlatoRepository implements IPlatoRepository{
    private final List<Ingrediente> databaseIngrediente;
    private final List<Plato> databasePlato;

    public PlatoRepository() {
        this.databaseIngrediente = loadDataBaseIngrediente();
        this.databasePlato = new ArrayList<Plato>();

        Ingrediente aceitunas = new Ingrediente("Aceitunas verdes", 47);
        Ingrediente tomate = new Ingrediente("Tomate", 18);

        // Crear objetos Plato y asignar ingredientes
        Map<Ingrediente, Integer> ensaladaIngredientes = new HashMap<>();
        ensaladaIngredientes.put(aceitunas, 40);
        ensaladaIngredientes.put(tomate, 60);
        Plato ensalada = new Plato("Ensalada", ensaladaIngredientes);

        databasePlato.add(ensalada);
    }

    private List<Ingrediente> loadDataBaseIngrediente() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    private List<Plato> loadDataBasePlato() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:plato.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Plato>> typeRef = new TypeReference<>() {};
        List<Plato> platos = null;
        try {
            platos = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return platos;
    }

    @Override
    public GetPlatoDto getPlato(String name, int peso) {

        Optional<Plato> platoBuscado = databasePlato.stream()
                .filter(plato -> plato.getNombre().equalsIgnoreCase(name))
                .findFirst();

        Plato platoEncontrado = platoBuscado.orElse(null);

        List<Ingrediente> listaIngredientes = new ArrayList<>(platoEncontrado.getIngredienteMap().keySet());

        assert platoEncontrado != null;
        GetPlatoDto platoRetornar = new GetPlatoDto(platoEncontrado.CalcularCalorias(peso), listaIngredientes);

        return platoRetornar;
    }
}
