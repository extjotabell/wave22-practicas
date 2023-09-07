package Spring.Covid19.Domain;

import Spring.Covid19.Domain.Dto.PersonaRiesgoDto;
import Spring.Covid19.Interfaces.IPersona;
import Spring.Covid19.Interfaces.ISintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital implements ISintoma, IPersona {
    private List<Persona> personas;
    private List<Sintoma> sintomas;
    @Override
    public List<Sintoma> obtenerSintomas() {
        return this.sintomas.stream().collect(Collectors.toList());
    }

    @Override
    public Sintoma obtenerSintomasPorNombre(String nombre) {
        return this.sintomas.stream().filter(sintoma -> sintoma.getNombre().toLowerCase().equals(nombre.toLowerCase())).findFirst().orElse(null);
    }
    @Override
    public List<PersonaRiesgoDto> obtenerPersonasDeRiesgo() {
        List<Sintoma> sintomaGravedad = this.sintomaPorGravedad("Alto");
        List<PersonaRiesgoDto> personasRiesgoList = new ArrayList<>();
        this.personas.stream().filter(persona -> persona.getEdad() >= 60).forEach(p ->
        {
            Optional<Sintoma> sintomaEncontrado = sintomaGravedad.stream().filter(sintomaGrav -> p.getCodigoDeSintoma() == sintomaGrav.getCodigo()).toList().stream().findAny();
            if (sintomaEncontrado.isPresent())
            {
                personasRiesgoList.add(new PersonaRiesgoDto(p.getNombre() + " " + p.getApellido(), sintomaEncontrado.get().getNombre()));
            }
        });
        if (!personasRiesgoList.isEmpty()) return personasRiesgoList;
        else return null;
    }

    @Override
    public List<Sintoma> sintomaPorGravedad(String gravedad)
    {
        return this.sintomas.stream().filter(sintoma -> sintoma.getNivel_de_gravedad().equals(gravedad)).collect(Collectors.toList());
    }
}
