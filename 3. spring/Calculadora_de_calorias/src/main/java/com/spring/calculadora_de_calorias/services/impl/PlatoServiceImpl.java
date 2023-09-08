package com.spring.calculadora_de_calorias.services.impl;

import com.spring.calculadora_de_calorias.repositories.IIngredienteRepository;
import com.spring.calculadora_de_calorias.repositories.IPlatoRepository;
import com.spring.calculadora_de_calorias.services.IPlatoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlatoServiceImpl implements IPlatoService {

    private final IPlatoRepository iPlatoRepository;
    @Override
    public Integer getTotalCaloriasPlato(String nombrePlato) {
        return iPlatoRepository.getAllCaloriasPlato(nombrePlato);
    }
}
