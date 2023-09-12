package com.bootcamp.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingrediente {
    private String nombre;
    private int calorias;
}
