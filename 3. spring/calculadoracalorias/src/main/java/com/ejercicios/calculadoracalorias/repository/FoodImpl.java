package com.ejercicios.calculadoracalorias.repository;

import com.ejercicios.calculadoracalorias.model.Food;

import java.util.List;

public class FoodImpl implements IRepository<Food, String>{
    @Override
    public List<Food> findAll() {
        return null;
    }

    @Override
    public Food find(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void add(Food obj) {

    }
}
