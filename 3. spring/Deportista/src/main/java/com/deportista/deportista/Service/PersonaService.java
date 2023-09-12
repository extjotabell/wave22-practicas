package com.deportista.deportista.Service;

import com.deportista.deportista.DTO.DeporteDTO;
import com.deportista.deportista.DTO.PersonaDTO;
import com.deportista.deportista.Models.Deporte;
import com.deportista.deportista.Models.Persona;
import com.deportista.deportista.Repository.IPersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    IPersonaRepository _repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<DeporteDTO> GetAllDeporte() {
        List<Deporte> deporteList= _repo.GetAllDeporte();
        return deporteList.stream().map(deporte -> mapper.map(deporte, DeporteDTO.class))
                                   .collect(Collectors.toList());
    }

    @Override
    public DeporteDTO GetByNameDeporte(String name) {
        Deporte deporte= _repo.GetByNameDeporte(name);
        return mapper.map(deporte, DeporteDTO.class);
    }

    @Override
    public List<PersonaDTO> GetPersona() {
       List<Persona> personaList= _repo.GetPersona();
        return personaList.stream().map(persona -> mapper.map(persona, PersonaDTO.class))
                                   .collect(Collectors.toList());
    }
}
