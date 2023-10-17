package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class StudentDTOTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Test StudentDTO Valid")
    void testStudentDTOValid() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("John");
        studentDTO.setAverageScore(9.5);
        studentDTO.setSubjects(List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 8.0)));

        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("Test StudentDTO Invalid")
    void testStudentDTOInvalid() {
        StudentDTO studentDTO = new StudentDTO();

        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO);

        assertTrue(!violations.isEmpty());
    }

    @Test
    @DisplayName("Test StudentDTO Name Validation")
    void testStudentDTONameValidation() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("john");

        Set<ConstraintViolation<StudentDTO>> violations = validator.validateProperty(studentDTO, "studentName");

        assertEquals(1, violations.size());
        ConstraintViolation<StudentDTO> violation = violations.iterator().next();
        assertEquals("El nombre del estudiante debe comenzar con mayúscula.", violation.getMessage());
    }
}
