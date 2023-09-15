package com.calculadoraDeCalorias.calculadoraDeCalorias.repository;

import com.calculadoraDeCalorias.calculadoraDeCalorias.entity.Dish;
import com.calculadoraDeCalorias.calculadoraDeCalorias.entity.Ingredient;

import java.util.List;

public interface IRepositoryCalculadora {
    void loadDataBase();
    List<Dish> getAllDishes();
}
