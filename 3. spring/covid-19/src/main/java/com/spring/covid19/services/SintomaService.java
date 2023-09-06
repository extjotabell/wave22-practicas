package com.spring.covid19.services;

import com.spring.covid19.entities.Sintoma;

import java.util.List;

public interface SintomaService {
    List<Sintoma> findAllSintomas();
    Sintoma findSintomaByName(String name);
}
