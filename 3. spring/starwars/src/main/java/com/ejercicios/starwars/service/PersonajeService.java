package com.ejercicios.starwars.service;

import com.ejercicios.starwars.dto.PersonajeDTO;
import com.ejercicios.starwars.entity.Personaje;
import com.ejercicios.starwars.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    IRepository repository;

    @Override
    public List<PersonajeDTO> getAll() {
        /* List<Personaje> personajesList = repository.getAll();
        List<PersonajeDTO> personajeDTOSList = new ArrayList<>();

        for (Personaje e : personajesList){
            PersonajeDTO personajeDTO = new PersonajeDTO(e.getName(),e.getHeight(),e.getMass(),e.getGender(),e.getHome_world(),e.getSpecies());
            personajeDTOSList.add(personajeDTO);
        }*/

        return repository.getAll().stream()
                .map(e -> new PersonajeDTO(e.getName(), e.getHeight(), e.getMass(), e.getGender(), e.getHomeworld(), e.getSpecies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDTO> findByName(String searchKeyword) {
        List<Personaje> personajes = repository.findByName(searchKeyword);
        List<PersonajeDTO> resultados = new ArrayList<>();

        for (Personaje personaje : personajes) {
            resultados.add(new PersonajeDTO(
                    personaje.getName(),
                    personaje.getHeight(),
                    personaje.getMass(),
                    personaje.getGender(),
                    personaje.getHomeworld(),
                    personaje.getSpecies()
            ));
        }

        return resultados;
    }

    @Override
    public void save(PersonajeDTO personajeDTO) {
        // Convierte el PersonajeDTO en un objeto Personaje
        Personaje personaje = new Personaje(
                personajeDTO.getName(),
                personajeDTO.getHeight(),
                personajeDTO.getMass(),
                personajeDTO.getGender(),
                personajeDTO.getHome_world(),
                personajeDTO.getSpecies()
        );

        // Guarda el Personaje en el repositorio
        repository.save(personaje);
    }
}
