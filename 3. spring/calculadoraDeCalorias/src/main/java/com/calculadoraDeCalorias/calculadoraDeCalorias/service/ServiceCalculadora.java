package com.calculadoraDeCalorias.calculadoraDeCalorias.service;

import com.calculadoraDeCalorias.calculadoraDeCalorias.dto.DishDto;
import com.calculadoraDeCalorias.calculadoraDeCalorias.entity.Dish;
import com.calculadoraDeCalorias.calculadoraDeCalorias.entity.Ingredient;
import com.calculadoraDeCalorias.calculadoraDeCalorias.exception.NotFoundException;
import com.calculadoraDeCalorias.calculadoraDeCalorias.repository.IRepositoryCalculadora;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class ServiceCalculadora implements IServiceCalculadora{
    private final IRepositoryCalculadora repository;

    public ServiceCalculadora(IRepositoryCalculadora repository) {
        this.repository = repository;
    }

    @Override
    public DishDto getDish(String name, double weight) {
        Optional<Dish> dish = repository.getAllDishes().stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findFirst();

        if(!dish.isPresent()){
            throw new NotFoundException("Dish doesn't exists");
        }

        Optional<Ingredient> maxCaloriesIngredient = dish.get().getIngredients().stream()
                .max(Comparator.comparing(Ingredient::getCalories));

        DishDto dishDto = new DishDto((int) (dish.get().getIngredients().stream()
                        .mapToInt(Ingredient::getCalories)
                        .sum() * (weight/100)),
                dish.get().getIngredients(),
                maxCaloriesIngredient.get());

        return dishDto;
    }

}
