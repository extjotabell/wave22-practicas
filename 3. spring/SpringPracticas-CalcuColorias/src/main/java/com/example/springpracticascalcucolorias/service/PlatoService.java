package com.example.springpracticascalcucolorias.service;

import com.example.springpracticascalcucolorias.dto.GetPlatoDto;
import com.example.springpracticascalcucolorias.repository.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoService implements IPlatoService{

    @Autowired
    IPlatoRepository platoRepository;
    @Override
    public GetPlatoDto getPlato(String name, int peso) {
        return platoRepository.getPlato(name, peso);
    }
}
