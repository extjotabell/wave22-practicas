package com.escuela.sistemaEstudiantes.service;

import com.escuela.sistemaEstudiantes.dtos.EstudianteDTO;
import com.escuela.sistemaEstudiantes.model.Estudiante;
import com.escuela.sistemaEstudiantes.repository.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService implements IEstudianteService{

    @Autowired
    IEstudianteRepository repo;
    @Override
    public List<EstudianteDTO> getAllEstudiantes() {
        List<Estudiante> estudiantes = repo.getAllEstudiantes();
        List<EstudianteDTO> estudiantesDTOS = new ArrayList<>();

        //mappear de Estudiante a EstudianteDTO (podemos implementar ModelMapper)
        for (Estudiante e :estudiantes) {
            EstudianteDTO eDTO = new EstudianteDTO(e.getEstudianteId(),e.getNombre(),e.getApellido(),e.getDni());
            estudiantesDTOS.add(eDTO);
        }
        return estudiantesDTOS;

    }

    @Override
    public void saveEstudiante(EstudianteDTO estudiante) {
        Estudiante estudianteToSave = new Estudiante(estudiante.getEstudianteId(), estudiante.getNombre(),estudiante.getApellido(), estudiante.getDni());
        repo.saveEstudiante(estudianteToSave);
    }
}
