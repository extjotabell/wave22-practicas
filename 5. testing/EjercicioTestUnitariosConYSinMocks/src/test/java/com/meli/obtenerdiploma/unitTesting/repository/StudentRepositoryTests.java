package com.meli.obtenerdiploma.unitTesting.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class StudentRepositoryTests {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        File sourceFile = new File("src/main/resources/users.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Set<StudentDTO> sourceData = objectMapper.readValue(sourceFile, new TypeReference<Set<StudentDTO>>() {});
            File targetFile = new File("src/test/resources/usersTest.json");
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(targetFile, sourceData);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al crear el archivo de prueba JSON.");
        }
    }

    @AfterEach
    void after(){
        File file = new File("src/test/resources/usersTest.json");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void findAll(){
        //Arrange
        Set<StudentDTO> expected = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("src/test/resources/usersTest.json");
            expected = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        //Act & Assert
        Assertions.assertEquals(expected.size(), studentRepository.findAll().size());
    }
}
