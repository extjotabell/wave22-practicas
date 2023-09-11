package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.InformeCaloricoDTO;
import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;
import com.bootcamp.calorias.repository.CaloryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CaloryServiceImpl implements CaloryService {

    private final CaloryRepository caloryRepository;

    @Override
    public InformeCaloricoDTO obtenerInformeCalorico(String nombrePlato, int peso) {
        Plato plato = caloryRepository.obtenerPlatoPorNombre(nombrePlato);

        double caloriasTotal = obtenerCaloriasTotales(plato, peso);
        String ingredientesConMasCalorias = obtenerIngredienteConMasCalorias(plato);
        List<Ingrediente> ingredientesPlato = obtenerIngredientesDelPlato(plato);

        return InformeCaloricoDTO.builder()
                .caloriasTotales(caloriasTotal)
                .nombreDelIngredienteMasCalorico(ingredientesConMasCalorias)
                .listaDeIngredientesYCalorias(ingredientesPlato)
                .build();
    }

    private double obtenerCaloriasTotales(Plato plato, int peso) {
        double total = 0;
        for (Map.Entry<Ingrediente, Double> entry : plato.getProporciones().entrySet()) {
            double pesoPropocionalIngrediente = (entry.getValue() * peso);
            total += (pesoPropocionalIngrediente * entry.getKey().getCalories()) / 100;
        }

        return total;
    }

    private String obtenerIngredienteConMasCalorias(Plato plato) {
        int caloriasMaximas = 0;
        String ingredienteConMasCalorias = "";
        for (Map.Entry<Ingrediente, Double> entry : plato.getProporciones().entrySet()) {
            if (entry.getKey().getCalories() > caloriasMaximas) {
                caloriasMaximas = entry.getKey().getCalories();
                ingredienteConMasCalorias = entry.getKey().getName();
            }
        }
        return ingredienteConMasCalorias;
    }

    private List<Ingrediente> obtenerIngredientesDelPlato(Plato plato) {
        List<Ingrediente> ingredientesPlato = new ArrayList<>();
        for (Map.Entry<Ingrediente, Double> entry : plato.getProporciones().entrySet()) {
            ingredientesPlato.add(entry.getKey());
        }
        return ingredientesPlato;
    }

}
