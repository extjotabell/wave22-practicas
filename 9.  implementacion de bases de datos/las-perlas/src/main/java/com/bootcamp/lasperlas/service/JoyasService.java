package com.bootcamp.lasperlas.service;

import com.bootcamp.lasperlas.dto.JoyaDTO;
import com.bootcamp.lasperlas.model.Joya;
import com.bootcamp.lasperlas.repository.JoyasRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyasService {
    private final JoyasRepository joyasRepository;
    private final ObjectMapper objectMapper;

    public JoyasService(JoyasRepository joyasRepository, ObjectMapper objectMapper) {
        this.joyasRepository = joyasRepository;
        this.objectMapper = objectMapper;
    }

    public List<JoyaDTO> findAll() {
        return this.joyasRepository
                .findAll()
                .stream()
                .map(joya -> this.objectMapper.convertValue(joya, JoyaDTO.class))
                .collect(Collectors.toList());
    }

    public String createJewel(JoyaDTO joyaDTO) {
        Joya j = this.objectMapper.convertValue(joyaDTO, Joya.class);
        j = this.joyasRepository.save(j);
        return "Joya Creada: " + j.getNroIdentificatorio();
    }

    public String deleteJewel(Long id) {
        Joya j = this.joyasRepository.findByNroIdentificatorio(id);
        j.setVenta(false);
        this.joyasRepository.save(j);
        return "Joya removida de la venta: " + objectMapper.convertValue(j, JoyaDTO.class).toString();
    }

    public String updateJewel(Long id, JoyaDTO joyaDTO) {
        Joya j = this.objectMapper.convertValue(joyaDTO, Joya.class);
        j.setNroIdentificatorio(id);
        this.joyasRepository.save(j);
        return "Joya updated: " + j.toString();
    }
}
