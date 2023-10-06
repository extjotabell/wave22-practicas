package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.dto.ResponseDTO;

import java.util.List;

public interface IJoyeriaService {

    Long create(JoyaDTO joyaDTO);

    List<JoyaDTO> getAll();

    ResponseDTO eliminar(Long id);

    JoyaDTO updateJewel(Long id, JoyaDTO joyaDTO);

}
