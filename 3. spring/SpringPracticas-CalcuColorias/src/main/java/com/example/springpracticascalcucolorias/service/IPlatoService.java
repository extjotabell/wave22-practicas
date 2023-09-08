package com.example.springpracticascalcucolorias.service;

import com.example.springpracticascalcucolorias.dto.GetPlatoDto;

public interface IPlatoService {
    GetPlatoDto getPlato(String name, int peso);
}
