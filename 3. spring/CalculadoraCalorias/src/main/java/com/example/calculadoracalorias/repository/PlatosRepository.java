package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.model.Ingrediente;
import com.example.calculadoracalorias.model.Plato;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class PlatosRepository {
    @Getter
    private List<Plato> platoList;

    private IngredientesRepository ingredientesRepository;

    public PlatosRepository() {
        this.platoList = new ArrayList<>();
        this.ingredientesRepository = new IngredientesRepository();
        for (int i = 0; i < 10; i++) {
            List<Ingrediente> list = this.generateIngredientes();
            Plato p = new Plato(new StringBuilder().append("Plato-").append(i).toString(), this.generateIngredientes(), this.calculateCalories(list), 100);
            platoList.add(p);
        }

    }

    public Plato getPlatoByName(String name) {
        return this.platoList.stream().filter(plato -> plato.getName().equals(name)).findFirst().orElse(null);
    }

    private List<Ingrediente> generateIngredientes(){
        List<Ingrediente> ingredienteList = this.ingredientesRepository.getAllIngredientes();
        Collections.shuffle(ingredienteList);
        return ingredienteList.subList(0,5);
    }

    private Integer calculateCalories(List<Ingrediente> list){
        return (int) list.stream().mapToInt(Ingrediente::getCalories).average().orElse(0.0);
    }
}
