package Spring.EjercicioCalculadoraCalorias.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private String name;
    private List<Ingredient> ingredients;
    private Double weight;
}
