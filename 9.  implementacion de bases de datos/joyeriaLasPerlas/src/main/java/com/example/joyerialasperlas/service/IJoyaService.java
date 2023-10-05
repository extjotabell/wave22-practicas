package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    List<JoyaDto> getAllJewelry();
    JoyaDto getJewelry(Long id);
    Long saveJewerly(JoyaDto joyaDto);
    void deleteJewerly(Long id);
    Long updateJewerly(Long id, JoyaDto joyaDto);
}
