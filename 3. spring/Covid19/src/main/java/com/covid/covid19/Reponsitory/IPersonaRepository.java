package com.covid.covid19.Reponsitory;

import com.covid.covid19.Entity.Persona;
import com.covid.covid19.Entity.Sintoma;

import java.util.List;

public interface IPersonaRepository {
    List<Sintoma> AllSintoma();
    Sintoma GetSintoma(String name);
    List<Persona> GetPersona();
}
