package com.example.ejerciciopersonajessw.service;

import com.example.ejerciciopersonajessw.dto.CaracterDto;

import java.util.List;

public interface ICaracterService {

    List<CaracterDto> getByName(String name);
}
