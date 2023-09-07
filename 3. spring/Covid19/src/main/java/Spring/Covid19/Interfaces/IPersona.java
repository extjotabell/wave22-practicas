package Spring.Covid19.Interfaces;

import Spring.Covid19.Domain.Dto.PersonaRiesgoDto;

import java.util.List;

public interface IPersona {
    List<PersonaRiesgoDto> obtenerPersonasDeRiesgo();
}
