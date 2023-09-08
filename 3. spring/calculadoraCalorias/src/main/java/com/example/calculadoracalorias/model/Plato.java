package com.example.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    private String nombre;
    private List<Food> listaIngredientes;
    private int totalCalorias;

    public Plato(String nombre,List<Food> listaIngredientes){
        this.nombre=nombre;
        this.listaIngredientes = listaIngredientes;
    }

}
