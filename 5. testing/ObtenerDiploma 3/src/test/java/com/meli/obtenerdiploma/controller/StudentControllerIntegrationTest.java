package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.jsonpath.JsonPath;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void registerStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(3L);
        studentDTO.setStudentName("Pepe");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payloadJason = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJason))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void registerStudentReturn400() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(3L);
        studentDTO.setStudentName("pepe");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payloadJason = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJason))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();

    }

    @Test
    void getStudent() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andReturn();

    }
    @Test
    void getStudentReturn404() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    void modifyStudent() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(3L);
        studentDTO.setStudentName("Pepe");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payloadJason = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJason))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void modifyStudentReturn404() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(3L);
        studentDTO.setStudentName("pepe");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payloadJason = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJason))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();

    }

    @Test
    void removeStudent() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andReturn();
    }

    @Test
    void listStudents() throws Exception {

        Set<StudentDTO> list = new HashSet<>();



        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}