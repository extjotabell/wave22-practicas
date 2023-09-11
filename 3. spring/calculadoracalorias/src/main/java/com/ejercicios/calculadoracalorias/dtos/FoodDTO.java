package com.ejercicios.calculadoracalorias.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

    private String nombre;
    private int calories;
}
