package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void  saveStudentTestOk() throws Exception {

        List<SubjectDTO> subjectDTOList = new ArrayList<>(){{
            add(new SubjectDTO("Java",4.0));
            add(new SubjectDTO("Testing", 6.0));
        }};

        StudentDTO studentDTO = new StudentDTO(3L,"Belu", "un mensaje" , 7.0, subjectDTOList);


        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void getStudentById() throws Exception {

        mockMvc.perform(get("/student/getStudent/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.studentName").value("Belu"))
                .andExpect(jsonPath("$.subjects[0].name").value("Java"));
    }



    @Test
    void  ModifyStudentTestOk() throws Exception {

        List<SubjectDTO> subjectDTOList = new ArrayList<>(){{
            add(new SubjectDTO("Java",4.0));
            add(new SubjectDTO("Testing", 6.0));
        }};

        StudentDTO studentDTO = new StudentDTO(1L,"Belu", "un mensaje nuevo" , 7.0, subjectDTOList);


        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void listStudentsTestOk() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    void removeStudentTestOk() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk());


    }

}
