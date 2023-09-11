package com.example.covid19.service.impl;

import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.model.Sintoma;
import com.example.covid19.repository.SintomaRepository;
import com.example.covid19.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaServiceImpl implements ISintomaService {
    @Autowired
    SintomaRepository repository;
    @Override
    public List<Sintoma> getAll() {
        return repository.getAll();
    }

    @Override
    public SintomaDTO findByName(String name) {
        Sintoma sintoma = repository.findByName(name);
        SintomaDTO dto = new SintomaDTO(sintoma.getNombre(), sintoma.getNivel_de_gravedad());
        return dto;
    }


}
