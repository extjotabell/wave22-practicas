package Spring.EjercicioCalculadoraCalorias.Service;


import Spring.EjercicioCalculadoraCalorias.Dtos.IngredientDTO;
import Spring.EjercicioCalculadoraCalorias.Entities.Ingredient;
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
        return repository.getPlato(name, peso).getIngredients().stream().mapToDouble(o -> o.getCalories()).sum();
    }

    @Override
    public List<IngredientDTO> getIngredientesByPlato(String name) {
        List<Ingredient> getIngredients = repository.getAllIngredientsByName(name);
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

}
