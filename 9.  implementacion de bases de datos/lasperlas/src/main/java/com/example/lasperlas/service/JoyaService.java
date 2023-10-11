package com.example.lasperlas.service;

import com.example.lasperlas.dto.JoyaDto;
import com.example.lasperlas.model.Joya;
import com.example.lasperlas.repository.IJoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    private IJoyaRepository joyaRepository;

    private ObjectMapper mapper;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public JoyaDto agregarJoya(JoyaDto joyaDto) {
        Joya joya = joyaRepository.save(mapper.convertValue(joyaDto, Joya.class));
        return mapper.convertValue(joya, JoyaDto.class);
    }

    @Override
    public JoyaDto updateJoya(Long id, JoyaDto joyaDto) {
        if(joyaRepository.existsById(id)) {
            Joya joyaAGuardar = mapper.convertValue(joyaDto, Joya.class);
            joyaAGuardar.setId(id);
            joyaRepository.save(joyaAGuardar);
            return mapper.convertValue(joyaAGuardar, JoyaDto.class);
        }
        return null;

    }

    @Override
    public List<JoyaDto> getJoyas() {
        List<Joya> joyas = joyaRepository.findAll();
        List<JoyaDto> joyasDto = new ArrayList<>();
        for (Joya j : joyas) {
            joyasDto.add(mapper.convertValue(j, JoyaDto.class));
        }
        return joyasDto;
    }

    @Override
    public void borrarJoya(Long id) {
        joyaRepository.deleteById(id);
    }
}
