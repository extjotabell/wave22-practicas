package Spring.Deportista.Domain;

import Spring.Deportista.Domain.Dto.DeporteDto;
import Spring.Deportista.Domain.Dto.DeporteNivelDto;
import Spring.Deportista.Domain.Dto.PersonaDeportistaDto;
import Spring.Deportista.Interfaces.IDeporte;
import Spring.Deportista.Interfaces.IPersona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClubDeIDeporte implements IDeporte, IPersona {
    private String nombre;
    private List<Persona> personas;
    @Override
    public ArrayList<DeporteDto> findSports() {
        if (!this.personas.isEmpty())
        {
        ArrayList<DeporteDto> deporteDtos = new ArrayList<DeporteDto>();
                this.personas.forEach(persona -> {
                    deporteDtos.add(new DeporteDto(persona.getDeporte().getNombre(), persona.getDeporte().getNivel()));
                });
                return deporteDtos;
        }
        else return null;
    }
    @Override
    public DeporteNivelDto sportsByName(String name)
    {
        Optional<Deporte> deporteEncontrado = this.personas.stream().map(Persona::getDeporte).
                filter(x -> x.getNombre().toLowerCase().equals(name.toLowerCase())).findFirst();
        if (deporteEncontrado.isPresent())
        {
            return new DeporteNivelDto(deporteEncontrado.get().getNivel());
        }
        else return null;

    }

    @Override
    public List<PersonaDeportistaDto> findSportsPersons() {
        if(!this.personas.isEmpty())
        {
            List<PersonaDeportistaDto> listaPersonas = new ArrayList<>();
            this.personas.stream().forEach(persona ->
            {
                listaPersonas.add(new PersonaDeportistaDto(persona.getNombre() + " " + persona.getApellido(), persona.getDeporte().getNombre()));
            });
            return listaPersonas;
        }
        else return null;
    }
}
