package com.example.covid19.service;

import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.model.Sintoma;

import java.util.List;

public interface ISintomaService {
    List<Sintoma> getAll();
    SintomaDTO findByName(String name);
}
