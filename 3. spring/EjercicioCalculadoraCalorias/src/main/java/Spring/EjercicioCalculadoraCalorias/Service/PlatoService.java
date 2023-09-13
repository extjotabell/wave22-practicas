package Spring.EjercicioCalculadoraCalorias.Service;


import Spring.EjercicioCalculadoraCalorias.Dtos.IngredientDTO;
import Spring.EjercicioCalculadoraCalorias.Entities.Ingredient;
import Spring.EjercicioCalculadoraCalorias.Entities.Plato;
import Spring.EjercicioCalculadoraCalorias.Exceptions.PlatoNotFoundException;
import Spring.EjercicioCalculadoraCalorias.Repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService implements IPlatoService {
    @Autowired
    private PlatoRepository repository;
    @Override
    public Double getCaloriasTotales(String name, Double peso) {
        Plato plato = repository.getPlato(name, peso);
        if (plato == null) throw new PlatoNotFoundException("No se encontro el plato solicitado");
        return plato.getIngredients().stream().mapToDouble(o -> o.getCalories()).sum();
    }

    @Override
    public List<IngredientDTO> getIngredientesByPlato(String name) {
        List<Ingredient> getIngredients = repository.getAllIngredientsByName(name);
        if (getIngredients == null) throw new PlatoNotFoundException("No se encontro el plato solicitado");
        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        if (!getIngredients.isEmpty())
        {
            getIngredients.forEach( i ->
            {
                ingredientDTOS.add(new IngredientDTO(i.getName(), i.getCalories()));
            });
        }
        return ingredientDTOS;
    }

    @Override
    public IngredientDTO highestIngredientCalories() {
        Ingredient ingredient = repository.highestIngredientCalories();
        return  new IngredientDTO(ingredient.getName(), ingredient.getCalories());
    }

    @Override
    public IngredientDTO highestIngredientCaloriesByPlato(String name) {
        Ingredient ingredient = repository.highestIngredientCaloriesByPlato(name);
        if (ingredient == null) throw new PlatoNotFoundException("No se encontro el plato solicitado.");
        return new IngredientDTO(ingredient.getName(), ingredient.getCalories());
    }

}
