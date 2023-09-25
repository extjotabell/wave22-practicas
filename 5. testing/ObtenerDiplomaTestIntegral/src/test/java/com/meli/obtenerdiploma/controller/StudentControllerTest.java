package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;


import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudentTest() throws Exception {

        StudentDTO testPostDto = new StudentDTO(3L,"Jose","",0.0,
                         List.of(new SubjectDTO("Matemática",7.7),
                                 new SubjectDTO("Física",5.7),
                                 new SubjectDTO("Química",9.5)
                                 ));

        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(testPostDto);
        System.out.println(jsonPayload);
        MvcResult mvcResult =  mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload) )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void getStudentTest() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}",1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.subjects").exists());
    }
    @Test
    void getStudentErrorTest() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}",5L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description" , containsString("5")));
    }
    @Test
    void modifyStudentTest() throws Exception {

        StudentDTO testPostDto = new StudentDTO(2L,"Jose","",0.0,
                List.of(new SubjectDTO("Matemática",8.7),
                        new SubjectDTO("Física",4.7),
                        new SubjectDTO("Química",10.0)
                ));

        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(testPostDto);
        System.out.println(jsonPayload);
        MvcResult mvcResult =  mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void removeStudentTest()throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}",3L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist()) ;
    }
    @Test
    void listStudentsTest()throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").exists()) ;
    }

}
