package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static StudentDAO studentDAO;
    private static ObjectWriter objectWriter;
    private static Set<StudentDTO> students;
    private static StudentDTO studentDTO;

    @BeforeAll
    public static void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        studentDAO = new StudentDAO();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Math", 10.0));
        subjectDTOList.add(new SubjectDTO("Spanish", 10.0));
        studentDTO = new StudentDTO(9999999L, "Alumnotest", "Gran pj", 10.0, subjectDTOList);
        studentDAO.save(studentDTO);
        students = studentDAO.getStudents();
    }

    @AfterAll
    public static void removeTestUserFromDB(){
        studentDAO.delete(studentDTO.getId());
    }

    @Test
    void registerStudent() throws Exception {
    }

    @Test
    void getStudent() {
    }

    @Test
    void modifyStudent() {
    }

    @Test
    void removeStudentOK() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",studentDTO.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudents() throws Exception {
        String listStudentsJSON = objectWriter.writeValueAsString(students);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(listStudentsJSON));
    }
}