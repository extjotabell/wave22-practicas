package com.calculadoraCalorias.CalculadoraCalorias.dtos;

import com.calculadoraCalorias.CalculadoraCalorias.models.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {
    private String name;
    private List<Food> ingredients;
}
