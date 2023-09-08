package com.spring.calculadora_de_calorias.repositories.impl;

import com.spring.calculadora_de_calorias.entities.Ingrediente;
import com.spring.calculadora_de_calorias.entities.Plato;
import com.spring.calculadora_de_calorias.repositories.IPlatoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {

    List<Ingrediente> ingredientes;
    List<Plato> platos;
    @Override
    public Integer getAllCaloriasPlato(String nombrePlato) {
        Plato plato = buscarPlatoPorNombre(nombrePlato);
        Integer maxCalories = 0;
        for (Ingrediente i : plato.getIngredientes()) {
            maxCalories += i.getCalories();
        }
        return maxCalories;
    }

    private Plato buscarPlatoPorNombre(String nombre) {
        Plato platoEncontrado = null;
        for (Plato plato: platos) {
            if(Objects.equals(plato.getName(), nombre)) {
                platoEncontrado = plato;
            }
        }
        return platoEncontrado;
    }
}
