package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentDAOTest {

    private final IStudentDAO studentDAO = new StudentDAO();

    @Test
    @Order(1)
    void saveTestOk() throws NoSuchFieldException, IllegalAccessException {
        StudentDTO studentDTO = new StudentDTO(3L, "Renzo", null, null, List.of(new SubjectDTO("Math", 10.0)));
        studentDAO.save(studentDTO);
        Assertions.assertTrue(getStudents().contains(studentDTO));
    }

    @Test
    void deleteOkTest() {
        Assertions.assertTrue(studentDAO.delete(1L));
    }

    @Test
    void deleteExceptionTest() {
        Assertions.assertFalse(studentDAO.delete(10L));
    }

    @Test
    @Order(2)
    void existsOkTest() {
        StudentDTO studentDTO = new StudentDTO(3L, "Renzo", null, null, List.of(new SubjectDTO("Math", 10.0)));
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void existsBadTest() {
        StudentDTO studentDTO = new StudentDTO(8L, "Renzo", null, null, List.of(new SubjectDTO("Math", 10.0)));
        Assertions.assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    @Order(3)
    void findByIdOkTest() {
        StudentDTO studentDTO = new StudentDTO(3L, "Renzo", null, null, List.of(new SubjectDTO("Math", 10.0)));
        Assertions.assertEquals(studentDTO, studentDAO.findById(3L));
    }

    @Test
    void findByIdExceptionTest() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(9L));
    }

    private Set<StudentDTO> getStudents() throws NoSuchFieldException, IllegalAccessException {
        Field studentsField = studentDAO.getClass().getDeclaredField("students");
        studentsField.setAccessible(true);
        return (Set<StudentDTO>) studentsField.get(studentDAO);
    }
}