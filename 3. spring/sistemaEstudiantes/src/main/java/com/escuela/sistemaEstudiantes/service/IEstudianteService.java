package com.escuela.sistemaEstudiantes.service;

import com.escuela.sistemaEstudiantes.dtos.EstudianteDTO;

import java.util.List;

public interface IEstudianteService {
    List<EstudianteDTO> getAllEstudiantes();

    void saveEstudiante(EstudianteDTO estudiante);
}
