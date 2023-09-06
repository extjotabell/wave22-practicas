package com.covid19.covid19;

import com.covid19.covid19.DTO.PersonaDTO;
import com.covid19.covid19.entidades.Persona;
import com.covid19.covid19.entidades.Sintoma;
import com.covid19.covid19.repositorios.RepositorioDTO;
import com.covid19.covid19.repositorios.RepositorioPersona;
import com.covid19.covid19.repositorios.RepositorioSintoma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Covid19Application {

	public static void main(String[] args) {
		SpringApplication.run(Covid19Application.class, args);
		Sintoma sintoma1 = new Sintoma(1,"Fiebre",1);
		Sintoma sintoma2 = new Sintoma(2,"DolorMuscular",1);
		Sintoma sintoma3 = new Sintoma(3,"DificultadRespiratoria",5);
		Sintoma sintoma4 = new Sintoma(4,"DolorDePecho", 4);
		RepositorioSintoma repositorioSintoma = new RepositorioSintoma();
		repositorioSintoma.agregarSintomas(sintoma1);
		repositorioSintoma.agregarSintomas(sintoma2);
		repositorioSintoma.agregarSintomas(sintoma3);
		repositorioSintoma.agregarSintomas(sintoma4);
		Persona persona1 = new Persona(1,"Cecilia","Morlacchi",32);
		Persona persona2 = new Persona(2,"Ivan","Basualdo",39);
		Persona persona3 = new Persona(3,"Eduardo","Morlacchi",74);
		Persona persona4 = new Persona(4,"Mery","Silva",61);
		RepositorioPersona repositorioPersona = new RepositorioPersona();
		repositorioPersona.agregarPersona(persona1);
		repositorioPersona.agregarPersona(persona2);
		repositorioPersona.agregarPersona(persona3);
		repositorioPersona.agregarPersona(persona4);
		PersonaDTO personaDTO1 = new PersonaDTO();
		PersonaDTO personaDTO2 = new PersonaDTO();
		PersonaDTO personaDTO3 = new PersonaDTO();
		PersonaDTO personaDTO4 = new PersonaDTO();
		personaDTO1.setEdad(persona3.getEdad());
		personaDTO1.setFullName(persona3.getNombre() + " " + persona3.getApellido());
		personaDTO1.setSintoma(sintoma1.getNombre());
		personaDTO2.setEdad(persona4.getEdad());
		personaDTO2.setFullName(persona4.getNombre() + " " + persona4.getApellido());
		personaDTO2.setSintoma(sintoma3.getNombre());
		personaDTO3.setSintoma(sintoma1.getNombre());
		personaDTO3.setEdad(persona1.getEdad());
		personaDTO3.setFullName(persona1.getNombre() + " " + persona1.getApellido());
		personaDTO4.setFullName(persona2.getNombre() + " " + persona2.getApellido());
		personaDTO4.setEdad(persona2.getEdad());
		personaDTO4.setSintoma(sintoma4.getNombre());
		RepositorioDTO repositorioDTO = new RepositorioDTO();
		repositorioDTO.agregarPersonaDTO(personaDTO1);
		repositorioDTO.agregarPersonaDTO(personaDTO2);
		repositorioDTO.agregarPersonaDTO(personaDTO3);
		repositorioDTO.agregarPersonaDTO(personaDTO4);
	}

}
