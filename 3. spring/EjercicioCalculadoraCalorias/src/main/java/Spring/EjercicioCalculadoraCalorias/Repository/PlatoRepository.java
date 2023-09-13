package Spring.EjercicioCalculadoraCalorias.Repository;

import Spring.EjercicioCalculadoraCalorias.Entities.Ingredient;
import Spring.EjercicioCalculadoraCalorias.Entities.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Repository
public class PlatoRepository implements IPlatoRepository {
    private List<Ingredient> ingredients;
    private List<Plato> platos;

    public PlatoRepository(List<Ingredient> ingredients, List<Plato> platos) {
        this.ingredients = loadDataBase();
        this.platos = crearMenu();
    }

    private List<Ingredient> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredientes = null;

        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return ingredientes;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return this.loadDataBase();
    }

    private Plato getPlatoByName(String name)
    {
        return this.platos.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    @Override
    public List<Ingredient> getAllIngredientsByName(String name)
    {
        Plato plato = getPlatoByName(name);
        if (plato == null) return null;
        return plato.getIngredients().stream().toList();
    }

    @Override
    public List<Plato> getAllPlatos() {
        return this.platos;
    }

    @Override
    public Plato getPlato(String name, Double weight) {
        return this.platos.stream().filter(p -> p.getName().equalsIgnoreCase(name) && p.getWeight().equals(weight)).findFirst().get();
    }

    @Override
    public Ingredient highestIngredientCalories() {
        List<Ingredient> sortedIngredients = this.ingredients;
        return sortedIngredients.stream().sorted(Comparator.comparing(Ingredient::getCalories).reversed()).findFirst().orElse(null);
    }

    @Override
    public Ingredient highestIngredientCaloriesByPlato(String name) {
        List<Ingredient> ingredientList= this.getAllIngredientsByName(name);
        if (ingredientList == null) return null;
        return ingredientList.stream().sorted(Comparator.comparing(Ingredient::getCalories).reversed()).findFirst().orElse(null);
    }

    private Ingredient getIngrediente(String name){
        return this.ingredients.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    private List<Plato> crearMenu(){
        List<Ingredient> ingredients = loadDataBase();
        List<Plato> platoList = new ArrayList<>();
        Plato lasagna = new Plato("Lasagna",
                List.of(
                        getIngrediente("Acelgas"),
                        getIngrediente("Tomates")),
                300.0);
        Plato patoALaNaranja = new Plato("Pato a la naranja",
                List.of(
                        getIngrediente("Pato"),
                        getIngrediente("Naranja")),
                300.0);
        Plato ciervo = new Plato("Ciervo",
                List.of(
                        getIngrediente("Ciervo"),
                        getIngrediente("Champiñón y otras setas")),
                300.0);
        platoList.add(lasagna);
        platoList.add(patoALaNaranja);
        platoList.add(ciervo);
        return platoList;
    }
}
