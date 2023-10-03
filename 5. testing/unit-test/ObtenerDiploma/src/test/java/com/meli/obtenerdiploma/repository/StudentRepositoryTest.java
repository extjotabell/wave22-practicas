package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class StudentRepositoryTest {

    Set<StudentDTO> students = new HashSet<>();
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findAll_test() throws FileNotFoundException {
        System.out.println("Ejecutando...");
        studentRepository = new StudentRepository();
        StudentDTO s1 = new StudentDTO(1l, "Maria", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        StudentDTO s2 = new StudentDTO(2l, "Carla", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        StudentDTO s3 = new StudentDTO(3l, "Ana", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        StudentDTO s4 = new StudentDTO(4l, "Juan", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        StudentDTO s5 = new StudentDTO(5l, "Pepe", "message", 10.0, List.of(new SubjectDTO("Ciencia", 10.0)));
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        studentRepository.setSCOPE("main");
        Set<StudentDTO> studentDTOSet = studentRepository.findAll();
        Assertions.assertAll(() -> Assertions.assertNotNull(studentDTOSet),
                () -> Assertions.assertEquals(students.size(), studentDTOSet.size()));
    }

    @Test
    void should_throwFileNotFoundException_whenNoScopeProvided() {
        studentRepository.setSCOPE(null);
        Assertions.assertThrows(FileNotFoundException.class, () -> studentRepository.findAll());
    }

}