package Spring.EjercicioCalculadoraCalorias.Service;



import Spring.EjercicioCalculadoraCalorias.Dtos.IngredientDTO;

import java.util.List;

public interface IPlatoService {
    Double getCaloriasTotales(String name, Double peso);
    List<IngredientDTO> getIngredientesByPlato(String name);
    public IngredientDTO highestIngredientCalories();
    public IngredientDTO highestIngredientCaloriesByPlato(String name);
}