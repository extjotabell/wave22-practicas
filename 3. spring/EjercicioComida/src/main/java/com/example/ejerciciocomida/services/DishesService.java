package com.example.ejerciciocomida.services;

import com.example.ejerciciocomida.dtos.CaloriasDto;
import com.example.ejerciciocomida.dtos.IngredientDto;
import com.example.ejerciciocomida.entities.Dish;
import com.example.ejerciciocomida.entities.Ingredient;
import com.example.ejerciciocomida.repositories.ICaloriesRepository;
import com.example.ejerciciocomida.repositories.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishesService  implements IDishesService{
    @Autowired
    IDishRepository dishRepository;
    @Autowired
    ICaloriesRepository caloriesRepository;

    @Override
    public CaloriasDto getCalories(String name, Integer weigth) {
        List<Ingredient> ingredientes = dishRepository.getIngredients(name);
        Dish plato = dishRepository.getDish(name);
        Double porcion = (double) weigth/plato.getWeigth();
        Double totalCalories = 0.0;
        for (Ingredient ingre: ingredientes) {
            totalCalories+=(caloriesRepository.getCalories(ingre.getName())*porcion);
        }
        return new CaloriasDto(totalCalories);
    }

    @Override
    public List<IngredientDto> getListIngredient(String name) {
        List<Ingredient> ingredientes = dishRepository.getIngredients(name);
        List<IngredientDto> resp = new ArrayList<>();
        for (Ingredient ingredient: ingredientes) {
            IngredientDto ingrdientDto = new IngredientDto(ingredient.getName(), caloriesRepository.getCalories(ingredient.getName()));
            resp.add(ingrdientDto);
        }
        return resp;
    }

    @Override
    public IngredientDto getWorstIngredient(String name) {
        List<Ingredient> ingredientes = dishRepository.getIngredients(name);
        List<IngredientDto> resp = new ArrayList<>();
        Ingredient worst = ingredientes.get(0);
        for (int i = 1; i < ingredientes.size() ; i++) {
            if (caloriesRepository.getCalories(worst.getName()) < caloriesRepository.getCalories(ingredientes.get(i).getName())){
                worst = ingredientes.get(i);
            }
        }
        return new IngredientDto(worst.getName(), caloriesRepository.getCalories(worst.getName()));
    }


}
