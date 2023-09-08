package com.example.starwars.service.impl;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.mapper.StarWarsMapper;
import com.example.starwars.repository.StarWarsRepository;
import com.example.starwars.service.StarWarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StarWarsServiceImpl implements StarWarsService {

    private final StarWarsRepository starWarsRepository;
    private final StarWarsMapper starWarsMapper;

    @Override
    public List<PersonajeDTO> getAllByName(String name) {
        if(name == null){
            return starWarsRepository.getAll().stream().map(starWarsMapper::toDTO).toList();
        }else{
            return starWarsRepository.getAllByName(name).stream().map(starWarsMapper::toDTO).toList();
        }
    }
}
