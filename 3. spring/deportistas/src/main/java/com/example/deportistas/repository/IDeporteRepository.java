package com.example.deportistas.repository;

import com.example.deportistas.model.Deporte;

import java.util.List;

public interface IDeporteRepository {
    public List<Deporte> getAll();
    public Deporte getByName(String name);
}
