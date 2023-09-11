package com.bootcamp.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plato {
    private String nombre;
    private Map<Ingrediente, Double> proporciones;
}
