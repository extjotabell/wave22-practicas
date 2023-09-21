package com.meli.obtenerdiploma.integrationTest;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectWriter mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    @Test
    void registerStudent() throws Exception{

        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Pepito");

        String payLoad = mapper.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoad))
                        .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getStudent() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        stu.setId(1L);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}",1);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(mapper.writeValueAsString(stu));
        MvcResult result = mockMvc.perform(request)//ejercutar request
                .andExpect(statusExpected) //cotejar body
                .andExpect(contentTypeExpected) //coincidir status
                // .andExpect(contentExpected) //coincidir content type
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void modifyStudent() throws Exception {
        /*
            COMMENT FOR BUILD
               this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoad))
                        .andDo(print()).andExpect(status().isOk());
         */

        List<SubjectDTO> subjectDTOS = new ArrayList<>() {{
            add(new SubjectDTO("Ingles", 10.0));
            add(new SubjectDTO("Fisica", 8.2));
            add(new SubjectDTO("Finanzas", 4.4));
        }};

        StudentDTO studentToUpdate = StudentDTO.builder()
                .id(2L)
                .studentName("Joaquin")
                .averageScore(8.7)
                .subjects(subjectDTOS)
                .build();

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(studentToUpdate))
        )
                .andExpect(status().isOk());
    }

    @Test
    void removeStudent() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        stu.setId(1L);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/removeStudent/{id}",1);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)//ejercutar request
                .andExpect(statusExpected) //cotejar body
                .andExpect(contentTypeExpected) //coincidir status
                // .andExpect(contentExpected) //coincidir content type
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void listStudents() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}