package com.meli.joyeria.service;

import com.meli.joyeria.dto.JoyaDTO;

import java.util.List;

public interface IJoyeriaService {
    String crearJoya(JoyaDTO joyaDTO);
    List<JoyaDTO> listar();
    String softDelete(Long id);
    String update(JoyaDTO joyaDTO);
}
