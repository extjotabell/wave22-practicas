package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Food;
import com.example.calculadoracalorias.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepoIMP implements IRepo<Plato,String>{


    List<Plato> platos;

    public PlatoRepoIMP(){
        this.platos = new ArrayList<>();

        FoodRepoIMP foodRepo = new FoodRepoIMP();


        Plato plato1= new Plato("Milanesa",new ArrayList<>());

        plato1.getListaIngredientes().add(foodRepo.getByName("Queso mozzarella"));
        plato1.getListaIngredientes().add(foodRepo.getByName("Harina de trigo integral"));
        plato1.getListaIngredientes().add(foodRepo.getByName("Tomates"));

        Plato plato2 = new Plato("Shawarma",new ArrayList<>());

        plato2.getListaIngredientes().add(foodRepo.getByName("Coliflor"));
        plato2.getListaIngredientes().add(foodRepo.getByName("Coliflor"));

        platos.add(plato1);
        platos.add(plato2);
    }
    @Override
    public List<Plato> getAll() {
        return platos;
    }

    @Override
    public Plato getByName(String name) {
        return platos.stream()
                .filter(p -> p.getNombre().equals(name))
                .findFirst()
                .orElse(null);
    }
}
