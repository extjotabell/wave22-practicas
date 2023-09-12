package com.bootcamp.Caloriass.service;

import com.bootcamp.Caloriass.dto.InformeCaloricoDTO;
import com.bootcamp.Caloriass.entity.Ingrediente;
import com.bootcamp.Caloriass.entity.Plato;
import com.bootcamp.Caloriass.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class CaloryServiceImpl implements CaloryService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public InformeCaloricoDTO obtenerInformeCalorico(String plato, Integer gramaje){
        Plato platoEntity = restaurantRepository.getPlatoLlamado(plato);

        double caloriasTotal = obtenerCaloriasTotales(platoEntity, gramaje);
        String ingredientesConMasCalorias = obtenerIngredienteConMasCalorias(platoEntity);
        List<Ingrediente> ingredientesPlato = obtenerIngredientesDelPlato(platoEntity);

        return InformeCaloricoDTO.builder()
                .caloriasTotales(caloriasTotal)
                .nombreDelIngredienteMasCalorico(ingredientesConMasCalorias)
                .listaDeIngredientesYCalorias(ingredientesPlato)
                .build();
    }

    private double obtenerCaloriasTotales(Plato plato, int peso){
        double total = 0;
        for(Map.Entry<Ingrediente, Double> entry : plato.getProporciones().entrySet()){
            double pesoPropocionalIngrediente = (entry.getValue() * peso);
            total += (pesoPropocionalIngrediente * entry.getKey().getCalories()) / 100;
        }

        return total;
    }

    private String obtenerIngredienteConMasCalorias(Plato plato){
        int caloriasMaximas = 0;
        String ingredienteConMasCalorias ="";
        for(Map.Entry<Ingrediente, Double> entry : plato.getProporciones().entrySet()){
            if(entry.getKey().getCalories() > caloriasMaximas){
                caloriasMaximas = entry.getKey().getCalories();
                ingredienteConMasCalorias = entry.getKey().getName();
            }
        }
        return ingredienteConMasCalorias;
    }

    private List<Ingrediente> obtenerIngredientesDelPlato(Plato plato){
        List<Ingrediente> ingredientesPlato = new ArrayList<>();
        for(Map.Entry<Ingrediente, Double> entry : plato.getProporciones().entrySet()){
            ingredientesPlato.add(entry.getKey());
        }
    return ingredientesPlato;
    }

}
