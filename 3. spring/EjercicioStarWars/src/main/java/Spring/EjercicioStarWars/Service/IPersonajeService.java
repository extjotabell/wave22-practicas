package Spring.EjercicioStarWars.Service;

import Spring.EjercicioStarWars.Dtos.PersonajeDto;
import Spring.EjercicioStarWars.Model.Personaje;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> getPersonajebyWord(String word);
}
