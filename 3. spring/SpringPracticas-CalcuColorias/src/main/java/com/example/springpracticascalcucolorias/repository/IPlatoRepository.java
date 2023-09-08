package com.example.springpracticascalcucolorias.repository;

import com.example.springpracticascalcucolorias.dto.GetPlatoDto;

public interface IPlatoRepository {

    GetPlatoDto getPlato(String name, int peso);
}
