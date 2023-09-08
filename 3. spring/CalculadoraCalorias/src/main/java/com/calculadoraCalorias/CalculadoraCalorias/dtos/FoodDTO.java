package com.calculadoraCalorias.CalculadoraCalorias.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private String name;
    private int calories;
    private int weigth;
}
