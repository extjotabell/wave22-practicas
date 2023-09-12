package Spring.EjercicioCalculadoraCalorias.Repository;


import Spring.EjercicioCalculadoraCalorias.Entities.Ingredient;
import Spring.EjercicioCalculadoraCalorias.Entities.Plato;

import java.util.List;

public interface IPlatoRepository {
    List<Ingredient> getAllIngredients();
    List<Ingredient> getAllIngredientsByName(String name);
    List<Plato> getAllPlatos();
    Plato getPlato(String name, Double weight);
    Ingredient highestIngredientCalories();
}
