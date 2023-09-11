package com.example.ejerciciocomida.services;

import com.example.ejerciciocomida.entities.Dish;
import com.example.ejerciciocomida.entities.Ingredient;
import com.example.ejerciciocomida.repositories.ICaloriesRepository;
import com.example.ejerciciocomida.repositories.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishesService  implements IDishesService{
    @Autowired
    IDishRepository dishRepository;
    @Autowired
    ICaloriesRepository caloriesRepository;

    @Override
    public Double getCalories(String name, Integer weigth) {
        List<Ingredient> ingredientes = dishRepository.getIngredients(name);
        Dish plato = dishRepository.getDish(name);
        Double porcion = (double) weigth/plato.getWeigth();
        Double totalCalories = 0.0;
        for (Ingredient ingre: ingredientes) {
            totalCalories+=(caloriesRepository.getCalories(ingre.getName())*porcion);
        }
        return totalCalories;
    }


}
