package com.example.deportistas.service;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService implements IDeporteService {

    @Autowired
    DeporteRepository repository;


    @Override
    public List<Deporte> getAll() {
        return repository.getAll();
    }

    @Override
    public Deporte getByName(String name) {
        return repository.getByName(name);
    }
}
