package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    public void registerStudent() throws Exception{
        // arrange

        StudentDTO stu = getStudentWithId(9999L);

        String jsonPayload = mapper.writeValueAsString(stu);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(jsonPayload))
                .andDo(print()).andExpect(status().isOk());


    }

    @Test
    public void getStudent() throws Exception {
        // arrange
        StudentDTO stu = getStudentWithId(9999L);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", stu.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(stu.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(stu.getStudentName()))
                .andReturn();

    }

    @Test
    public void getStudentEmpty() throws Exception {
        // arrange
        StudentDTO stu = getStudentWithId(3L);
        String exceptionMessage = "El alumno con Id " + stu.getId() + " no se encuetra registrado.";

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", stu.getId()))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(exceptionMessage))
                .andReturn();

    }

    @Test
    public void modifyStudent() throws Exception{

        StudentDTO stu = getStudentWithId(9999L);

        String jsonPayload = mapper.writeValueAsString(stu);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void removeStudent() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", "2"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void listStudents() throws Exception {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        StudentDTO[] studentsArray = students.toArray(new StudentDTO[0]);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0].id").value(studentsArray[0].getId()));

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
