package Spring.EjercicioStarWars.Repository;

import Spring.EjercicioStarWars.Dtos.PersonajeDto;
import Spring.EjercicioStarWars.Model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository implements  IPersonajeRepository{
    List<Personaje> dataBase;

    public PersonajeRepository() {
        this.dataBase = loadDataBase();
    }

    @Override
    public List<Personaje> getAllPersonajes() {
        return this.loadDataBase();
    }

    @Override
    public List<Personaje> getPersonajeByNameContains(String name) {
        List<Personaje>  personajes = this.getAllPersonajes().
                stream().filter(x -> x.getName().toLowerCase().contains(name)).toList();
        return personajes;
    }

    private List<Personaje> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return characters;
    }
}
