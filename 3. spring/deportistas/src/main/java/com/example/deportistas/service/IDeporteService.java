package com.example.deportistas.service;

import com.example.deportistas.model.Deporte;

import java.util.List;

public interface IDeporteService {
    public List<Deporte> getAll();
    public Deporte getByName(String name);

}
