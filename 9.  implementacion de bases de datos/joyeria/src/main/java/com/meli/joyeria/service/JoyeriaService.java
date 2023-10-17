package com.meli.joyeria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.joyeria.dto.JoyaDTO;
import com.meli.joyeria.model.Joya;
import com.meli.joyeria.repository.JoyeriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyeriaService implements IJoyeriaService{
    private final JoyeriaRepository joyeriaRepository;
    ObjectMapper mapper;

    public JoyeriaService(JoyeriaRepository joyeriaRepository) {
        this.joyeriaRepository = joyeriaRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public String crearJoya(JoyaDTO joyaDTO) {
        Joya entity = mapper.convertValue(joyaDTO, Joya.class);
        entity.setVentaONo(true);
        joyeriaRepository.save(entity);
        return "Joya creada con el ID= " + entity.getId();
    }

    @Override
    public List<JoyaDTO> listar() {
        return joyeriaRepository
                .findAll()
                .stream()
                .map(o -> mapper.convertValue(o, JoyaDTO.class))
                .toList();
    }

    @Override
    public String softDelete(Long id) {
        Optional<Joya> entity = joyeriaRepository.findById(id);
        entity.ifPresent(e -> e.setVentaONo(false));
        return "Se ha eliminado la joya con el ID= " + id;
    }

    @Override
    public String update(JoyaDTO joyaDTO) {
        Joya entity = mapper.convertValue(joyaDTO, Joya.class);
        joyeriaRepository.save(entity);
        return "Joya actualizada con el ID= "+ entity.getId();
    }
}
