package com.bootcamp.Caloriass.repository;

import com.bootcamp.Caloriass.entity.Ingrediente;
import com.bootcamp.Caloriass.entity.Plato;
import com.bootcamp.Caloriass.repository.RestaurantRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    List<Ingrediente> listaDeIngredientes = new ArrayList<>();
    List<Plato> listaDePlatos = new ArrayList<>();

    public RestaurantRepositoryImpl(){
        listaDeIngredientes = loadDataBase();
        Ingrediente panRallado = getIngredienteLlamado("Pan de trigo integral");
        Ingrediente carne = getIngredienteLlamado("Ternera");
        Map<Ingrediente, Double> mapaDePlato1 = new HashMap<>();
        mapaDePlato1.put(panRallado, 0.5);
        mapaDePlato1.put(carne, 0.5);
        Plato plato1 = new Plato("Milanesa", mapaDePlato1);
        listaDePlatos.add(plato1);

        Ingrediente lechuga = getIngredienteLlamado("Lechuga");
        Ingrediente tomate = getIngredienteLlamado("Tomates");
        Map<Ingrediente, Double> mapaDePlato2 = new HashMap<>();
        mapaDePlato2.put(lechuga, 0.8);
        mapaDePlato2.put(tomate, 0.2);
        Plato plato2 = new Plato("Ensalada de lechuga y tomate", mapaDePlato2);
        listaDePlatos.add(plato2);

        Ingrediente salsaDeTomate = getIngredienteLlamado("Salsa de tomate en conserva");
        Ingrediente harinaDeTrigo = getIngredienteLlamado("Harina de trigo refinada");
        Ingrediente muzzarella = getIngredienteLlamado("Queso mozzarella");
        Map<Ingrediente, Double> mapaDePlato3 = new HashMap<>();
        mapaDePlato3.put(harinaDeTrigo, 0.4);
        mapaDePlato3.put(muzzarella, 0.3);
        mapaDePlato3.put(salsaDeTomate, 0.3);
        Plato plato3 = new Plato("Pizza", mapaDePlato3);
        listaDePlatos.add(plato3);
    }

    @Override
    public Plato getPlatoLlamado(String nombrePlato) {
        return listaDePlatos
                .stream()
                .filter(plato -> plato.getNombre().equals(nombrePlato))
                .findFirst()
                .get();
    }

    @Override
    public Ingrediente getIngredienteLlamado(String nombreIngrediente) {
        return listaDeIngredientes
                .stream()
                .filter(ingrediente -> ingrediente.getName().equals(nombreIngrediente))
                .findFirst()
                .get();
    }


    private List<Ingrediente> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredients = null;

        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return ingredients;
    }
}
