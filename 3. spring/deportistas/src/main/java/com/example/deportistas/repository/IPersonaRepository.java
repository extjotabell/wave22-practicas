package com.example.deportistas.repository;

import com.example.deportistas.model.Persona;

import java.util.List;

public interface IPersonaRepository {
    public List<Persona> getAll();
}
