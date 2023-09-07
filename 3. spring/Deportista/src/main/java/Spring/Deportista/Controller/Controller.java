package Spring.Deportista.Controller;

import Spring.Deportista.Domain.ClubDeIDeporte;
import Spring.Deportista.Domain.Deporte;
import Spring.Deportista.Domain.Dto.DeporteDto;
import Spring.Deportista.Domain.Dto.DeporteNivelDto;
import Spring.Deportista.Domain.Dto.PersonaDeportistaDto;
import Spring.Deportista.Domain.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private ClubDeIDeporte club = new ClubDeIDeporte("Club", List.of(
            new Persona("Pepito", "Perez", 30,
                    new Deporte("Futbol", "Medio")),
            new Persona("Juana", "Diaz", 25,
                    new Deporte("Tenis", "Alto")),
            new Persona("Tom", "Fernandez", 37, new Deporte("Natacion", "Bajo"))
    ));

    @GetMapping("/findSports")
    ResponseEntity<ArrayList<DeporteDto>> findSports()
    {
        ArrayList<DeporteDto> deportes = club.findSports();
        return deportes != null ? new ResponseEntity<>(deportes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSports/{name}")
    ResponseEntity<DeporteNivelDto> findSportsByName(@PathVariable String name)
    {
        DeporteNivelDto deporte = club.sportsByName(name);
        return deporte != null ? new ResponseEntity<>(deporte, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/findSportsPerson")
    ResponseEntity<List<PersonaDeportistaDto>> findSportsPerson()
    {
        List<PersonaDeportistaDto> listaPersonas = club.findSportsPersons();
        return listaPersonas!= null ? new ResponseEntity<>(listaPersonas, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
