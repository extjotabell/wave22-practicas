package com.calculadoraCalorias.CalculadoraCalorias.service;

import com.calculadoraCalorias.CalculadoraCalorias.dtos.DishCaloriesDTO;
import com.calculadoraCalorias.CalculadoraCalorias.dtos.DishDTO;
import com.calculadoraCalorias.CalculadoraCalorias.dtos.FoodDTO;
import com.calculadoraCalorias.CalculadoraCalorias.models.Dish;
import com.calculadoraCalorias.CalculadoraCalorias.models.Food;
import com.calculadoraCalorias.CalculadoraCalorias.repository.ICaloriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CaloriesServiceImp implements ICaloriesService{

    @Autowired
    ICaloriesRepository repo;

    @Override
    public DishCaloriesDTO calculateDish(DishDTO dish) {
        Dish dish1 = new Dish(dish.getName(),dish.getIngredients());
        int total = 0;
        Food mostCaloric;
        for(Food ingredient : dish1.getIngredients()){
            calculateCalories(ingredient);
            total += ingredient.getCalories();
        }
        //total = (int) dish1.getIngredients().stream().mapToDouble(i -> i.getCalories()).sum();
        mostCaloric = dish1.getIngredients().stream().max(Comparator.comparingDouble(Food::getCalories)).get();
        return new DishCaloriesDTO(dish1.getName(),total,dish1.getIngredients(),mostCaloric.getName());
    }

    private void calculateCalories(Food ingredient){
        ingredient.setCalories(0);
        Food foodRepository = repo.ingredientsInDish(ingredient.getName());
        int calories = ingredient.getWeigth() * foodRepository.getCalories();
        ingredient.setCalories(calories);
    }

    public List<DishCaloriesDTO> calculateDishAll (List<DishDTO> dishes) {
        List<DishCaloriesDTO> dishesSolve = new ArrayList<>();
        for(DishDTO dish : dishes){

            dishesSolve.add(this.calculateDish(dish));
        }
        
        return dishesSolve;
    }
    

}
