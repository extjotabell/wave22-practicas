package com.bootcamp.calories.service;

import com.bootcamp.calories.dto.CalorieReportDTO;
import com.bootcamp.calories.model.Ingredient;
import com.bootcamp.calories.model.Dish;
import com.bootcamp.calories.repository.IDishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CaloricService implements ICaloricService {
    //TODO: use the repository when appropiate. Currently there's unused data
    IDishRepository dishRepository;
    public CaloricService(IDishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public CalorieReportDTO getCalorieReport(String dishName, int grams){
        Dish dishEntity = dishRepository.getDishByName(dishName);

        double totalCalories = getTotalCalories(dishEntity, grams);
        String mostCaloricIngredient = getMostCaloricIngredient(dishEntity);
        List<Ingredient> dishIngredients = getAllIngredientsFromDish(dishEntity);

        return CalorieReportDTO.builder()
                .totalCalories(totalCalories)
                .mostCaloricDish(mostCaloricIngredient)
                .listOfIngredientsAndCalories(dishIngredients)
                .build();
    }

    private double getTotalCalories(Dish dish, int  peso){
        double total = 0;
        for(Map.Entry<Ingredient, Double> entry : dish.getProportions().entrySet()){
            double proportionalWeightPerIngredient = (entry.getValue() * peso);
            total += (proportionalWeightPerIngredient * entry.getKey().getCalories()) / 100;
        }
        return total;
    }

    private String getMostCaloricIngredient(Dish dish){
        int caloriasMaximas = 0;
        String ingredienteConMasCalorias ="";
        for(Map.Entry<Ingredient, Double> entry : dish.getProportions().entrySet()){
            if(entry.getKey().getCalories() > caloriasMaximas){
                caloriasMaximas = entry.getKey().getCalories();
                ingredienteConMasCalorias = entry.getKey().getName();
            }
        }
        return ingredienteConMasCalorias;
    }

    private List<Ingredient> getAllIngredientsFromDish(Dish dish){
        List<Ingredient> dishIngredients = new ArrayList<>();
        for(Map.Entry<Ingredient, Double> entry : dish.getProportions().entrySet()){
            dishIngredients.add(entry.getKey());
        }
    return dishIngredients;
    }

}
