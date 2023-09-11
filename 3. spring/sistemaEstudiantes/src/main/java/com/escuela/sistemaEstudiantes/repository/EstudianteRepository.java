package com.escuela.sistemaEstudiantes.repository;

import com.escuela.sistemaEstudiantes.model.Estudiante;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


@Repository
public class EstudianteRepository implements IEstudianteRepository{

    List<Estudiante> dataBase;

    public EstudianteRepository() {
        this.dataBase = loadDataBase();
    }

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return this.dataBase;
    }

    @Override
    public void saveEstudiante(Estudiante estudiante) {
        this.dataBase.add(estudiante);
    }

    private List<Estudiante> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:estudiantes.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TypeReference<List<Estudiante>> typeRef = new TypeReference<>() {};
        List<Estudiante> characters = null;

        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Database loading successfully...");
        return characters;
    }

}
