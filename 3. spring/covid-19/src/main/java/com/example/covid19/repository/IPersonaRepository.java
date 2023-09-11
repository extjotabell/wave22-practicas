package com.example.covid19.repository;

import com.example.covid19.model.Persona;

import java.util.List;

public interface IPersonaRepository {
    List<Persona> getAll();

}
