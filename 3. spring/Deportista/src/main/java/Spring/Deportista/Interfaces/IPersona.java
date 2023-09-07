package Spring.Deportista.Interfaces;

import Spring.Deportista.Domain.Dto.PersonaDeportistaDto;

import java.util.List;

public interface IPersona {
    List<PersonaDeportistaDto> findSportsPersons();
}
