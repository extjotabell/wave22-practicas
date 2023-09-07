package Spring.EjercicioStarWars.Service;

import Spring.EjercicioStarWars.Dtos.PersonajeDto;
import Spring.EjercicioStarWars.Model.Personaje;
import Spring.EjercicioStarWars.Repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {

    @Autowired
    IPersonajeRepository _personajeRepository;
    @Override
    public List<PersonajeDto> getPersonajebyWord(String word) {
        List<Personaje>  personajes = _personajeRepository.getAllPersonajes().
                stream().filter(x -> x.getName().toLowerCase().contains(word)).toList();
        List<PersonajeDto> personajeDtos = new ArrayList<>();
        for (Personaje personaje: personajes) {
            personajeDtos.add(new PersonajeDto(
                    personaje.getName(),
                    personaje.getHeight(),
                    personaje.getMass(),
                    personaje.getGender(),
                    personaje.getHomeWorld(),
                    personaje.getSpecies()
            ));
        }
        return personajeDtos;
    }
}
