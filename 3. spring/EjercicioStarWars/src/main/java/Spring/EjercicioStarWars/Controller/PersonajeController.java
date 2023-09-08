package Spring.EjercicioStarWars.Controller;

import Spring.EjercicioStarWars.Dtos.PersonajeDto;
import Spring.EjercicioStarWars.Service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
@RestController
public class PersonajeController {
    @Autowired
    PersonajeService _personajeService;

    @GetMapping("/personajesByName/{name}")
    public ResponseEntity<List<PersonajeDto>> getPersonajesByName(@PathVariable String name)
    {
        List<PersonajeDto> personajes = _personajeService.getPersonajeByNameContains(name);
        return !personajes.isEmpty() ? new ResponseEntity<>(personajes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
