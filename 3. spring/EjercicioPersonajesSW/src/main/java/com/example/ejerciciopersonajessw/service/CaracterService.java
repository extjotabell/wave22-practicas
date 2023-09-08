package com.example.ejerciciopersonajessw.service;

import com.example.ejerciciopersonajessw.dto.CaracterDto;
import com.example.ejerciciopersonajessw.entity.Caracter;
import com.example.ejerciciopersonajessw.repository.ICaracaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaracterService implements ICaracterService{

    @Autowired
    ICaracaterRepository caracaterRepository;

    @Override
    public List<CaracterDto> getByName(String name) {
        List<Caracter> caracters = caracaterRepository.searchByName(name);
        List<CaracterDto> caracterDtos = new ArrayList<>();
        for (Caracter caracter: caracters) {
            caracterDtos.add(new CaracterDto(caracter.getName(),caracter.getHeight(),caracter.getMass(),caracter.getGender(),caracter.getHomeworld(),caracter.getSpecies()));
        }
        return caracterDtos;
    }
}
