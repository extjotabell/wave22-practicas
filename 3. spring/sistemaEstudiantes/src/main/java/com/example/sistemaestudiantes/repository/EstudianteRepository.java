package com.example.sistemaestudiantes.repository;

import com.example.sistemaestudiantes.model.Estudiante;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.asm.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Repository // Le indica a spring boot que voy a estar iniciando un repositorio
public class EstudianteRepository implements IEstudianteRepository {

    List<Estudiante> dataBase; // Como todavia no vimos bases de datos la hardcodeamos
                               // Se puede hardcodear tanto en el constructor como en un JSON

    public EstudianteRepository() {
        this.dataBase = loadDataBase();
    }

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return this.dataBase;
    }

    public List<Estudiante> loadDataBase(){
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:estudiantes.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        TypeReference<List<Estudiante>>
    }

}
