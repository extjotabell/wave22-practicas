package com.example.sistemaestudiantes.service;

import com.example.sistemaestudiantes.model.Estudiante;
import com.example.sistemaestudiantes.model.EstudianteDTO;
import com.example.sistemaestudiantes.repository.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Le indica a spring boot que voy a estar iniciando un servicio
public class EstudianteService implements IEstudianteService {

    @Autowired
    IEstudianteRepository repo;

    @Override
    public List<EstudianteDTO> getAllEstudiantes() {
        List<Estudiante> estudiantes = repo.getAllEstudiantes(); // Aca NO es DTO porque es la info que viene del DAO

        List<EstudianteDTO> estudianteDTOS = new ArrayList<>();

        // Mappear de Estudiante a EstudianteDTO (podriamos implementar un ModelMapper)
        for (Estudiante e : estudiantes) {
            EstudianteDTO eDTO = new EstudianteDTO(e.getId(), e.getNombre(), e.getApellido(), e.getDni());
            estudianteDTOS.add(eDTO);
        }

        return estudianteDTOS;
    }
}
