package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    @BeforeAll
    static void SetUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void registerStudentTest() throws Exception {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica",9.0)
        );
        StudentDTO paramStudent = new StudentDTO(1L,"Randy","",null,subjects);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paramStudent)))
                .andExpect(status().isOk());
    }

    @Test
    void getStudentTest() throws Exception {
        long studentId = 1L;
        mockMvc.perform(get("/student/getStudent/{id}", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(studentId))
                .andExpect(jsonPath("$.studentName").value("Randy"));
    }

    @Test
    void modifyStudentTest() throws Exception {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica",9.0)
        );
        StudentDTO paramStudent = new StudentDTO(1L,"Randy","",null,subjects);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paramStudent)))
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentTest() throws Exception {
        long studentId = 1L;
        mockMvc.perform(get("/student/removeStudent/{id}", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void listStudentsTest() throws Exception {
        mockMvc.perform(get("/student/listStudents")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].studentName", equalTo("Pedro")));
    }
}
