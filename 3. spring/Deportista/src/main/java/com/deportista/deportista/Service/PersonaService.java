package com.deportista.deportista.Service;

import com.deportista.deportista.DTO.DeporteDTO;
import com.deportista.deportista.DTO.PersonaDTO;
import com.deportista.deportista.Models.Deporte;
import com.deportista.deportista.Models.Persona;
import com.deportista.deportista.Repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    IPersonaRepository _repo;
    @Override
    public List<DeporteDTO> GetAllDeporte() {
        List<Deporte> deporteList= _repo.GetAllDeporte();
        return deporteList.stream().map(x->new DeporteDTO(x.getNombre(),x.getNivel()))
                                   .collect(Collectors.toList());
    }

    @Override
    public DeporteDTO GetByNameDeporte(String name) {
        Deporte deporte= _repo.GetByNameDeporte(name);
        return new DeporteDTO(deporte.getNombre(),deporte.getNivel());

    }

    @Override
    public List<PersonaDTO> GetPersona() {
       List<Persona> personaList= _repo.GetPersona();
       return personaList.stream().map(x->new PersonaDTO(x.getNombre(),x.getApellido(),x.getDeporte().getNombre()))
                                  .collect(Collectors.toList());
    }
}
