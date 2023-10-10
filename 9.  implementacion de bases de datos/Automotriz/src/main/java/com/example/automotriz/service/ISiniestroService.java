package com.example.automotriz.service;

import com.example.automotriz.dto.SiniestroDTO;

import java.util.List;

public interface ISiniestroService {
    SiniestroDTO buscarPorId(Long id);
    List<SiniestroDTO> buscarTodos();
    String crearSiniestro(SiniestroDTO dto);
}
