package com.bootcamp.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@AllArgsConstructor
@Data
public class Plato {
    private String nombre;
    private Map<Ingrediente, Double> proporciones;
}
