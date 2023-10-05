package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.entity.Joya;
import com.example.joyeria.repository.IJoyeriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JoyeriaService implements IJoyeriaService {

    @Autowired
    IJoyeriaRepository repo;

    public Long create(JoyaDTO joyaDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Joya joya = mapper.convertValue(joyaDTO, Joya.class);
        return repo.save(joya).getNro_identificatorio();
    }

    @Override
    public List<JoyaDTO> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Joya> joyas = repo.findAll();
        return joyas.stream().map(joya -> mapper.convertValue(joya, JoyaDTO.class)).toList();
    }

}