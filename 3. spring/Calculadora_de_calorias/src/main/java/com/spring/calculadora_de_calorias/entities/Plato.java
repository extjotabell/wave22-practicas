package com.spring.calculadora_de_calorias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private String name;
    private Double peso;
    private List<Ingrediente> ingredientes;
}
