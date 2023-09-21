package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;

import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    @Autowired
    MockMvc mockMvc;

    /*@BeforeEach
    void appendStudents(){
        StudentDTO stu = TestUtilsGenerator.getStudentWithId(1L);
        TestUtilsGenerator.appendNewStudent(stu);
    }*/

    @Test
    public void obtenerDiploma() throws Exception {

        StudentDTO stu = getStudentWithId(9999L);
        TestUtilsGenerator.appendNewStudent(stu);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", stu.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(stu.getAverageScore()));

    }

    @Test
    public void obtenerDiplomaNotExists() throws Exception {

        Long id = 3L;
        String exceptionMessage = "El alumno con Id " + id + " no se encuetra registrado.";

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(exceptionMessage));

    }

    private static StudentDTO getStudentWithId(Long id) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(id);
        stu.setStudentName("Student1");
        stu.setSubjects(subjects);

        Double average = stu.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().orElse(0.0);
        String message = "El alumno " + stu.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#0.00").format(average)
                + ". Puedes mejorar.";

        stu.setAverageScore(average);
        stu.setMessage(message);

        return stu;
    }

}
