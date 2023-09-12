package com.covid.covid19.Service;

import com.covid.covid19.dto.PersonaDto;
import com.covid.covid19.dto.SintomaDto;
import java.util.List;


public interface IPersonaService {
    List<SintomaDto> AllSintoma();
    SintomaDto GetSintoma(String name);
    List<PersonaDto> GetPersona();
}
