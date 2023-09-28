package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class StudentRepository implements IStudentRepository {

    private String SCOPE;

    public StudentRepository() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Set<StudentDTO> findAll() throws IOException {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
        loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {
        });


        return loadedData;
    }
}
