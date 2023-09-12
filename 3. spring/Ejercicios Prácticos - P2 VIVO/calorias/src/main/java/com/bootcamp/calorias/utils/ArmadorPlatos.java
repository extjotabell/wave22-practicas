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
    private List<Plato> listaDePlatos = new ArrayList<>();

    public static List<Plato> armar(List<Ingrediente> listaDeIngredientes) {
        Ingrediente panRallado = caloryRepository.obtenerIngredientePorNombre("Pan de trigo integral");
        Ingrediente carne = caloryRepository.obtenerIngredientePorNombre("Ternera");
        Map<Ingrediente, Double> mapaDePlato1 = new HashMap<>();
        mapaDePlato1.put(panRallado, 0.5);
        mapaDePlato1.put(carne, 0.5);
        Plato plato1 = new Plato("Milanesa", mapaDePlato1);
        listaDePlatos.add(plato1);

        Ingrediente lechuga = caloryRepository.obtenerIngredientePorNombre("Lechuga");
        Ingrediente tomate = caloryRepository.obtenerIngredientePorNombre("Tomates");
        Map<Ingrediente, Double> mapaDePlato2 = new HashMap<>();
        mapaDePlato2.put(lechuga, 0.8);
        mapaDePlato2.put(tomate, 0.2);
        Plato plato2 = new Plato("Ensalada de lechuga y tomate", mapaDePlato2);
        listaDePlatos.add(plato2);

        Ingrediente salsaDeTomate = caloryRepository.obtenerIngredientePorNombre("Salsa de tomate en conserva");
        Ingrediente harinaDeTrigo = caloryRepository.obtenerIngredientePorNombre("Harina de trigo refinada");
        Ingrediente muzzarella = caloryRepository.obtenerIngredientePorNombre("Queso mozzarella");
        Map<Ingrediente, Double> mapaDePlato3 = new HashMap<>();
        mapaDePlato3.put(harinaDeTrigo, 0.4);
        mapaDePlato3.put(muzzarella, 0.3);
        mapaDePlato3.put(salsaDeTomate, 0.3);
        Plato plato3 = new Plato("Pizza", mapaDePlato3);
        listaDePlatos.add(plato3);
    }


    @Override
    public List<Plato> getAllPlatos() {
        return listaDePlatos;
    }

}
