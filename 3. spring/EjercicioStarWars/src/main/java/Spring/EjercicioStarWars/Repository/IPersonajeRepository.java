package Spring.EjercicioStarWars.Repository;

import Spring.EjercicioStarWars.Model.Personaje;
import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getAllPersonajes();
    List<Personaje> getPersonajeByNameContains(String name);
}
