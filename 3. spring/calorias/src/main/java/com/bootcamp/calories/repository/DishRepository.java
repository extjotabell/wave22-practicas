package com.bootcamp.calories.repository;

import com.bootcamp.calories.model.Ingredient;
import com.bootcamp.calories.model.Dish;
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
public class DishRepository implements IDishRepository {
    private List<Dish> dishes;
    private final List<Ingredient> ingredients;
    private Map<Dish, Double> caloriesPerDishes;
    public DishRepository() {
        ingredients = loadDataBase();
        dishes = initDishes();
        caloriesPerDishes = initialCalculationOfCalories();
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishes;
    }

    @Override
    public Dish getDishByName(String name) {
        return dishes.stream().filter(dish -> dish.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return this.ingredients;
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return this.ingredients.stream().filter(ingredient -> ingredient.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private Map<Dish, Double> initialCalculationOfCalories() {
        caloriesPerDishes = new HashMap<>();
        for (Dish dish : dishes) {
            double calories = 0.0;
            for(Map.Entry<Ingredient, Double> entry : dish.getProportions().entrySet()) {
                Ingredient ingredient = entry.getKey();
                Double proportion = entry.getValue();
                calories += ingredient.getCalories() * proportion;
            }
            caloriesPerDishes.put(dish, calories);
        }
        return caloriesPerDishes;
    }

    private List<Dish> initDishes() {
        dishes = new ArrayList<>();

        Ingredient breadCrumbs = getIngredientByName("Pan de trigo integral");
        Ingredient meat = getIngredientByName("Ternera");
        Map<Ingredient, Double> dishIngredientProportion = new HashMap<>();
        dishIngredientProportion.put(breadCrumbs, 0.5);
        dishIngredientProportion.put(meat, 0.5);
        Dish dish = new Dish("Milanesa", dishIngredientProportion);
        dishes.add(dish);

        Ingredient lettuce = getIngredientByName("Lechuga");
        Ingredient tomato = getIngredientByName("Tomates");
        dishIngredientProportion = new HashMap<>();
        dishIngredientProportion.put(lettuce, 0.8);
        dishIngredientProportion.put(tomato, 0.2);
        dish = new Dish("Ensalada de lechuga y tomate", dishIngredientProportion);
        dishes.add(dish);

        Ingredient tomatoSauce = getIngredientByName("Salsa de tomate en conserva");
        Ingredient wheatFlour = getIngredientByName("Harina de trigo integral");
        Ingredient mozzarella = getIngredientByName("Queso mozzarella");
        dishIngredientProportion = new HashMap<>();
        dishIngredientProportion.put(tomatoSauce, 0.4);
        dishIngredientProportion.put(wheatFlour, 0.3);
        dishIngredientProportion.put(mozzarella, 0.3);
        dish = new Dish("Pizza", dishIngredientProportion);
        dishes.add(dish);

        return dishes;
    }

    private List<Ingredient> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
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
}
