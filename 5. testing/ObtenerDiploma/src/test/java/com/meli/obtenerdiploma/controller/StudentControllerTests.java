package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void registerValidStudent() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("Matematica",5D);
        StudentDTO studentDTO = new StudentDTO(null, "Gaspar", null, null, List.of(subjectDTO));
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payload = mapper.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void registerNotValidStudent() throws Exception {
        SubjectDTO subjectDTO = new SubjectDTO("matematica",5D); //Materia empieza con minuscula
        StudentDTO studentDTO = new StudentDTO(null, "Gaspar", null, null, List.of(subjectDTO));
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payload = mapper.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void getStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"));
    }

    @Test
    void getNotValidStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",-1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"));
    }

    //@Test
    //void modifyStudent() {
//
    //}

    @Test
    void removeStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].studentName").value("Pedro"));
    }
}
