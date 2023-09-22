package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
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

import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void PostRegisterStudent_OK() throws Exception {
        StudentDTO studentDto = new StudentDTO(2L, "Carlos", "", 7.0,
                List.of(
                        new SubjectDTO("Quimica", 7.0),
                        new SubjectDTO("Fisica", 7.0)
                )
        );

        String payloadJson = this.writer.writeValueAsString(studentDto);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void PostRegisterStudent_ThrowsException() throws Exception {

        StudentDTO studentDto = new StudentDTO();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(studentDto);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }

    @Test
    public void getStudent() throws Exception {
        //Arrange
        StudentDTO studentDto = new StudentDTO(2L, "Carlos", "", 7.0,
                List.of(
                        new SubjectDTO("Quimica", 7.0),
                        new SubjectDTO("Fisica", 7.0)
                )
        );
        //La request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}", 2L);

        //Lo expected
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(studentDto));

        mockMvc.perform(request)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getStudent_ThrowsException() throws Exception {
        long id = 510;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}", id);

        ResultMatcher expectedStatus = status().isNotFound();

        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(jsonPath("$.description").value("El alumno con Id " + id + " no se encuetra registrado."))
                .andDo(print());
    }

    @Test
    void modifyStudent_OK() throws Exception {
        StudentDTO studentDto = new StudentDTO(2L, "Juan Carlos", "", 7.0,
                List.of(
                        new SubjectDTO("Química", 7.0),
                        new SubjectDTO("Física", 7.0)
                )
        );

        String payloadJson = this.writer.writeValueAsString(studentDto);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

        // TODO: add assertion to verify that a new student was added
        // TODO: add another test to verify when a student is updated
    }

    @Test
    void deleteStudent_OK() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/removeStudent/{id}", 2L);

        ResultMatcher expectedStatus = status().isOk();

        mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andDo(print());
    }

    @Test
    void listStudents_OK() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/listStudents");

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andDo(print())
                .andReturn();

        String body = result.getResponse().getContentAsString();
        Set<StudentDTO> students = mapper.readValue(body, new TypeReference<>() {
        });
        Assertions.assertEquals(1, students.size());


    }

}
