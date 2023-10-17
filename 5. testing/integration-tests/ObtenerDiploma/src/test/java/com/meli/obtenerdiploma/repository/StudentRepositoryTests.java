package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class StudentRepositoryTests {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;
    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach((stu) -> studentDAO.save(stu));

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }

    @Test
    @DisplayName("Test findAll with FileNotFoundException")
    void testFindAllWithFileNotFoundException() throws Exception {
        when(objectMapper.readValue(Mockito.any(File.class), Mockito.any(TypeReference.class)))
                .thenThrow(FileNotFoundException.class);

        Set<StudentDTO> students = studentRepo.findAll();

        assertTrue(students.isEmpty());
    }

    @Test
    @DisplayName("Test findAll with IOException")
    void testFindAllWithIOException() throws Exception {
        when(objectMapper.readValue(Mockito.any(File.class), Mockito.any(TypeReference.class)))
                .thenThrow(IOException.class);

        Set<StudentDTO> students = studentRepo.findAll();

        assertTrue(students.isEmpty());
    }

    @Test
    @DisplayName("Test findAll with Valid Data")
    void testFindAllWithValidData() throws Exception {
        Set<StudentDTO> expectedData = new HashSet<>();
        when(objectMapper.readValue(Mockito.any(File.class), Mockito.any(TypeReference.class)))
                .thenReturn(expectedData);

        Set<StudentDTO> students =  studentRepo.findAll();

        assertEquals(expectedData, students);
    }

}
