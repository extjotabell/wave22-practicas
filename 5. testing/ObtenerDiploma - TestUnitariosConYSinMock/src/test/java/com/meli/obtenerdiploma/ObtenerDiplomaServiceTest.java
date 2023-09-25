package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analizeScoresTestOk(){
        //ARRANGE
        Set<StudentDTO> studentRepo = new HashSet<>();
        StudentDTO student = new StudentDTO((long)80, "Lulu", "Estudiante", null,
                List.of(new SubjectDTO("Matematicas", 7.5),
                        new SubjectDTO("Biologia", 8.0)));
        studentRepo.add(student);

        //ACT
        when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO expected = obtenerDiplomaService.analyzeScores(student.getId());
        student.setAverageScore(7.75);
        student.setMessage("El alumno " + student.getStudentName() + " ha obtenido un promedio de 7.75. Puedes mejorar.");

        //ASSERT
        assertEquals(expected, student);
    }
}
