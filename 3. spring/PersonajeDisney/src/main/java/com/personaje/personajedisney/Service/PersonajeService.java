package com.personaje.personajedisney.Service;

import com.personaje.personajedisney.Dto.PersonajeDto;
import com.personaje.personajedisney.Interface.IPersonajeRepository;
import com.personaje.personajedisney.Interface.IPersonajeService;
import com.personaje.personajedisney.Models.Personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {

    @Autowired
    IPersonajeRepository repo;

    @Override
    public List<PersonajeDto> GetPersonaje(String name) {

        List<Personaje> personajeList = repo.GetPersonaje(name);
        List<PersonajeDto> dtos = personajeList.stream().map(x-> new PersonajeDto(
                                                             x.getName(),x.getGender(),x.getHomeworld(),x.getSpecies(),
                                                             x.getHeight(),x.getMass()
                                                            )).collect(Collectors.toList());
        return dtos;

    }
}
