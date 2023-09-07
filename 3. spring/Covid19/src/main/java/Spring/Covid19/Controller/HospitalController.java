package Spring.Covid19.Controller;

import Spring.Covid19.Domain.Dto.PersonaRiesgoDto;
import Spring.Covid19.Domain.Hospital;
import Spring.Covid19.Domain.Persona;
import Spring.Covid19.Domain.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    private Hospital hospital = new Hospital(List.of(
            new Persona(1,"Pepito", "Fernandez", 70,1),
            new Persona(2,"Juana", "Diaz", 34,5),
            new Persona(3,"Martina", "Castro", 18,3),
            new Persona(4,"Mariana", "Lopez", 55,1)
    ), List.of(
            new Sintoma(1, "Cancer", "Alto"),
            new Sintoma(2, "Gripe", "Bajo"),
            new Sintoma(3, "Covid-19", "Alto"),
            new Sintoma(4, "Alergia", "Alto"),
            new Sintoma(5, "Infeccion urinaria", "Bajo")
    ));
    @GetMapping("/findSympthoms")
    public List<Sintoma> obtenerSintomas()
    {
        return hospital.obtenerSintomas();
    }

    @GetMapping("/findSympthoms/{name}")
    ResponseEntity<Sintoma> obtenerSintomasPorNombre(@PathVariable String name)
    {
        Sintoma sintoma = hospital.obtenerSintomasPorNombre(name);
        return sintoma != null ? new ResponseEntity<>(sintoma, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/findRiskPerson")
    ResponseEntity<List<PersonaRiesgoDto>> obtenerPacienteDeRiesgo()
    {
        List<PersonaRiesgoDto> personasRiesgo = hospital.obtenerPersonasDeRiesgo();
        return personasRiesgo != null ? new ResponseEntity<>(personasRiesgo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
