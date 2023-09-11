package com.restaurant.calories.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Dish {
    String name;
    Map<Ingredient, Double> ingredients= new HashMap<>();
}
