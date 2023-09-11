package com.example.covid19.repository;

import com.example.covid19.model.Sintoma;

import java.util.List;

public interface ISintomaRepository {
    List<Sintoma> getAll();
    Sintoma findByName(String name);


}
