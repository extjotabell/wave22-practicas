package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class StudentControllerTest {


    @MockBean
    private ObtenerDiplomaService service;

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void registerStudent() throws Exception {

        mockMvc.perform(post("http://localhost:8080/student/registerStudent")
                        .content("null"))
                .andExpect(status().isOk());

    }

    @Test
    void getStudent() {
    }

    @Test
    void modifyStudent() {
    }

    @Test
    void removeStudent() {
    }

    @Test
    void listStudents() {
    }
}