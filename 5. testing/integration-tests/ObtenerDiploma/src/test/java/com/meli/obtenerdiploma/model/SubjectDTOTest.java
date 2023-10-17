package com.meli.obtenerdiploma.model;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class SubjectDTOTest{
    private Validator validator;

    @BeforeEach
    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Test SubjectDTO Valid")
    void testSubjectDTOValid() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        subjectDTO.setScore(9.5);

        Set<ConstraintViolation<SubjectDTO>> violations = validator.validate(subjectDTO);

        assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("Test SubjectDTO Invalid")
    void testSubjectDTOInvalid() {
        SubjectDTO subjectDTO = new SubjectDTO();

        Set<ConstraintViolation<SubjectDTO>> violations = validator.validate(subjectDTO);

        assertTrue(!violations.isEmpty());
    }

    @Test
    @DisplayName("Test SubjectDTO Name Validation")
    void testSubjectDTONameValidation() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("math");

        Set<ConstraintViolation<SubjectDTO>> violations = validator.validateProperty(subjectDTO, "name");

        assertEquals(1, violations.size());
        ConstraintViolation<SubjectDTO> violation = violations.iterator().next();
        assertEquals("El nombre de la materia debe comenzar con mayúscula.", violation.getMessage());
    }

    @Test
    @DisplayName("Test SubjectDTO Score Validation")
    void testSubjectDTOScoreValidation() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Math");
        subjectDTO.setScore(11.0);

        Set<ConstraintViolation<SubjectDTO>> violations = validator.validateProperty(subjectDTO, "score");

        assertEquals(1, violations.size());
        ConstraintViolation<SubjectDTO> violation = violations.iterator().next();
        assertEquals("La nota máxima de la materia es de 10 pts.", violation.getMessage());
    }
}
