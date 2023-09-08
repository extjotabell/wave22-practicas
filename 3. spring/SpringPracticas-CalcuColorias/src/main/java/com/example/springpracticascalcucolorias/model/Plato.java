package com.example.springpracticascalcucolorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class Plato {
    private String nombre;
    private Map<Ingrediente, Integer> ingredienteMap;
    public Plato() {
    }
    public Plato(String nombre, Map<Ingrediente, Integer> listaIngredientes) {
        this.nombre = nombre;
        this.ingredienteMap = listaIngredientes;
    }
    public int CalcularCalorias(int peso){

        int totalCalorias = 0;

        for (Map.Entry<Ingrediente, Integer> entry : ingredienteMap.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            int porcentaje = entry.getValue();
            if (ingrediente != null) {
                int caloriasIngrediente = (int) (ingrediente.getCalories() * (porcentaje / 100.0) * (peso / 100));
                totalCalorias += caloriasIngrediente;
            }
        }

        return totalCalorias;
    }
}
