package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.InformeCaloricoDTO;
import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.model.Plato;
import com.bootcamp.calorias.repository.CaloryRepository;
import com.bootcamp.calorias.repository.PlatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CaloryServiceImpl implements CaloryService{

    @Autowired
    CaloryRepository caloryRepository;

    @Autowired
    PlatosRepository platosRepository;

    @Override
    public InformeCaloricoDTO obtenerInformeCalorico(String plato, int gramaje){
        Plato platoEntity = platosRepository.getPlatoLlamado(plato);

        double caloriasTotal = obtenerCaloriasTotales(platoEntity, gramaje);
        String ingredientesConMasCalorias = obtenerIngredienteConMasCalorias(platoEntity);
        List<Ingrediente> ingredientesPlato = obtenerIngredientesDelPlato(platoEntity);

        return InformeCaloricoDTO.builder()
                .caloriasTotales(caloriasTotal)
                .nombreDelIngredienteMasCalorico(ingredientesConMasCalorias)
                .listaDeIngredientesYCalorias(ingredientesPlato)
                .build();
    }

    private double obtenerCaloriasTotales(Plato plato,int  peso){
        double total = 0;
        for(Map.Entry<Ingrediente, Double> entry : plato.getProporciones().entrySet()){
            double pesoPropocionalIngrediente = (entry.getValue() * peso);
            total += (pesoPropocionalIngrediente * entry.getKey().getCalorias()) / 100;
        }

        return total;
    }

    private String obtenerIngredienteConMasCalorias(Plato plato){
        int caloriasMaximas = 0;
        String ingredienteConMasCalorias ="";
        for(Map.Entry<Ingrediente, Double> entry : plato.getProporciones().entrySet()){
            if(entry.getKey().getCalorias() > caloriasMaximas){
                caloriasMaximas = entry.getKey().getCalorias();
                ingredienteConMasCalorias = entry.getKey().getNombre();
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
