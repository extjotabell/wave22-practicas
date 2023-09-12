package Spring.EjercicioCalculadoraCalorias.Dtos;

import Spring.EjercicioCalculadoraCalorias.Entities.Ingredient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PlatoDTO {
    public String name;
    public Double peso;
    public Double cantidadTotalCalorias;
    public List<Ingredient> ingredients;
}