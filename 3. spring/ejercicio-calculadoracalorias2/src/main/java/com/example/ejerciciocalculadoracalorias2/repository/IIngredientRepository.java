package com.example.ejerciciocalculadoracalorias2.repository;

import com.example.ejerciciocalculadoracalorias2.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {

    List<Ingredient> findAllIngredients();
    Ingredient findIngredientByName(String name);
}
