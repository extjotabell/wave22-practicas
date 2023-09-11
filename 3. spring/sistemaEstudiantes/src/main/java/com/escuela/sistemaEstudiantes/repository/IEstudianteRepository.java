package com.escuela.sistemaEstudiantes.repository;

import com.escuela.sistemaEstudiantes.model.Estudiante;

import java.util.List;

public interface IEstudianteRepository {

    List<Estudiante> getAllEstudiantes();
    void saveEstudiante(Estudiante estudiante);
}
