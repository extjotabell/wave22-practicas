package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.xml.transform.Result;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer= new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    public void PostRegisterStudent_OK() throws Exception {
        StudentDTO studentDto = new StudentDTO(null, "Carlos", "hola", 7.0,
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
        StudentDTO studentDto = new StudentDTO(1L, "Carlos", "hola", 7.0,
                List.of(
                        new SubjectDTO("Quimica", 7.0),
                        new SubjectDTO("Fisica", 7.0)
                )
        );
        //La request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L);

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
    void modifyStudent_OK() throws Exception{
        StudentDTO studentDto = new StudentDTO(null, "Carlos", "hola", 7.0,
                List.of(
                        new SubjectDTO("Quimica", 7.0),
                        new SubjectDTO("Fisica", 7.0)
                )
        );

        String payloadJson = this.writer.writeValueAsString(studentDto);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudent_ThrowsException() throws Exception {
        long id = 530;
    }
}
