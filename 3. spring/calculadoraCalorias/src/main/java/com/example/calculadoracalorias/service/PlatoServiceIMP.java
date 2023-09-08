package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.FoodDTO;
import com.example.calculadoracalorias.dto.PlatoDTO;
import com.example.calculadoracalorias.model.Food;
import com.example.calculadoracalorias.model.Plato;
import com.example.calculadoracalorias.repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoServiceIMP implements IPlatoService{

    @Autowired
    IRepo<Plato,String> repo;


    @Override
    public PlatoDTO getCaloriasByName(String name) {

        Plato plato = repo.getByName(name);
        int total = plato.getListaIngredientes().stream().mapToInt(p -> p.getCalories()).sum();
        PlatoDTO platoDto = new PlatoDTO(plato.getNombre(), plato.getListaIngredientes(), total);
        return platoDto;

    }

    @Override
    public FoodDTO getFoodConMayorCalorias(String name) {


        Plato plato = repo.getByName(name);
        Food max = plato.getListaIngredientes().get(0);

        for (Food p : plato.getListaIngredientes()){
            if(max.getCalories()< p.getCalories()){
                max = p;
            }
        }

        FoodDTO foodDTO = new FoodDTO(max.getName(),max.getCalories());

        

        return foodDTO;



    }
}
