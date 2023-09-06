package com.covid19.covid19.repositorios;

import com.covid19.covid19.DTO.PersonaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDTO {
    public static List<PersonaDTO> personaDTOList = new ArrayList<>();

    public void agregarPersonaDTO(PersonaDTO persona){
        personaDTOList.add(persona);
    }

    public static List<PersonaDTO> getPersonaDTOList() {
        return personaDTOList;
    }

    public static List<PersonaDTO> buscarPersonaRiesgo(){
        List<PersonaDTO> personas = personaDTOList.stream().filter(p-> p.getEdad() >= 60 && p.getSintoma().length() > 0).collect(Collectors.toList());
        return personas;
    }
}
