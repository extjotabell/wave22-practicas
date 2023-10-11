package com.example.lasperlas.service;

import com.example.lasperlas.dto.JoyaDto;

import java.util.List;

public interface IJoyaService {

    JoyaDto agregarJoya(JoyaDto joyaDto);
    JoyaDto updateJoya(Long id, JoyaDto joyaDto);
    List<JoyaDto> getJoyas();
    void borrarJoya(Long id);


}
