package com.example.ejerciciocalculadoracalorias2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dish {

    private String name;
    private List<Ingredient> ingredients;

}
