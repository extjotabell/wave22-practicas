package com.bootcamp.calorias.utils;

import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;
import com.bootcamp.calorias.repository.CaloryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmadorPlatos {
    private static final List<Plato> listaDePlatos = new ArrayList<>();

    public static List<Plato> armar(List<Ingrediente> ingredientes) {
        Ingrediente panRallado = obtenerIngredientePorNombre(ingredientes, "Pan de trigo integral");
        Ingrediente carne = obtenerIngredientePorNombre(ingredientes, "Ternera");
        Map<Ingrediente, Double> mapaDePlato1 = new HashMap<>();
        mapaDePlato1.put(panRallado, 0.5);
        mapaDePlato1.put(carne, 0.5);
        Plato plato1 = new Plato("Milanesa", mapaDePlato1);
        listaDePlatos.add(plato1);

        Ingrediente lechuga = obtenerIngredientePorNombre(ingredientes, "Lechuga");
        Ingrediente tomate = obtenerIngredientePorNombre(ingredientes, "Tomates");
        Map<Ingrediente, Double> mapaDePlato2 = new HashMap<>();
        mapaDePlato2.put(lechuga, 0.8);
        mapaDePlato2.put(tomate, 0.2);
        Plato plato2 = new Plato("Ensalada de lechuga y tomate", mapaDePlato2);
        listaDePlatos.add(plato2);

        Ingrediente salsaDeTomate = obtenerIngredientePorNombre(ingredientes, "Salsa de tomate en conserva");
        Ingrediente harinaDeTrigo = obtenerIngredientePorNombre(ingredientes, "Harina de trigo refinada");
        Ingrediente muzzarella = obtenerIngredientePorNombre(ingredientes, "Queso mozzarella");
        Map<Ingrediente, Double> mapaDePlato3 = new HashMap<>();
        mapaDePlato3.put(harinaDeTrigo, 0.4);
        mapaDePlato3.put(muzzarella, 0.3);
        mapaDePlato3.put(salsaDeTomate, 0.3);
        Plato plato3 = new Plato("Pizza", mapaDePlato3);
        listaDePlatos.add(plato3);

        return listaDePlatos;
    }

    private static Ingrediente obtenerIngredientePorNombre(List<Ingrediente> ingredientes, String name) {
        return ingredientes.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst().get();
    }
}
