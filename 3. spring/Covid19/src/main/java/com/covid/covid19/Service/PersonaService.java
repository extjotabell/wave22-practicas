package com.covid.covid19.Service;

import com.covid.covid19.Entity.Persona;
import com.covid.covid19.Entity.Sintoma;
import com.covid.covid19.Reponsitory.IPersonaRepository;
import com.covid.covid19.dto.PersonaDto;
import com.covid.covid19.dto.SintomaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    IPersonaRepository _repo;

    @Override
    public List<SintomaDto> AllSintoma() {
       List<Sintoma> sintomaList =_repo.AllSintoma();
       return sintomaList.stream().map(x-> new SintomaDto(x.getNombre(),x.getNivelDegravedad())).collect(Collectors.toList());
    }

    @Override
    public SintomaDto GetSintoma(String name) {
        Sintoma sintoma  =_repo.GetSintoma(name);
        return new SintomaDto(sintoma.getNombre(),sintoma.getNivelDegravedad());
    }

    @Override
    public List<PersonaDto> GetPersona() {
       List<Persona> personaList = _repo.GetPersona();
       List<PersonaDto> personaDtoList = new ArrayList<>();
       for(Persona p : personaList){
           List<SintomaDto> sintoma = new ArrayList<>();
           for (Sintoma s : p.getSintomaList()){
               sintoma.add(new SintomaDto(s.getNombre(),s.getNivelDegravedad()));
           }
           personaDtoList.add(new PersonaDto(p.getNombre(),p.getApellido(), sintoma));
       }
       return personaDtoList;
    }
}
