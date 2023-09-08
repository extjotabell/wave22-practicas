package com.spring.calculadora_de_calorias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String nombre;
    private int calories;
}
