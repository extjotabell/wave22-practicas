package com.meli.obtenerdiploma.controller;


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

import java.awt.*;

import static com.meli.obtenerdiploma.util.TestUtilsGenerator.getStudentWith3Subjects;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getStudentAllOkTest() throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0]").isNotEmpty());
    }

    @Test
    void getStudentByIdOkTest() throws Exception {
        String param = "1";
        mockMvc.perform(get("/student/getStudent/{id}",param))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(param));
    }

    @Test
    void getStudentByIdNotFoundTest() throws Exception {
        String param = "122222";
        mockMvc.perform(get("/student/getStudent/{id}",param))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id "+param+" no se encuetra registrado."));
    }

    @Test
    void studentModifyOkTest() throws Exception {
        StudentDTO param = getStudentWith3Subjects("Jorge");

        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(param);
        System.out.println(jsonPayload);

        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(status().isOk());
    }

    @Test
    void studentModifyNotValidTest() throws Exception {
        StudentDTO param = getStudentWith3Subjects("");

        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(param);
        System.out.println(jsonPayload);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void getRemoveOkTest() throws Exception {
        String param = "1";
        mockMvc.perform(get("/student/removeStudent/{id}",param))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void studentRegisterOkTest() throws Exception {
        StudentDTO param = getStudentWith3Subjects("Enzo");

        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = mapper.writeValueAsString(param);
        System.out.println(jsonPayload);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk());
    }

    @Test
    void studentRegisterBadContentTest() throws Exception {

        String test = "{\"id\":forceError,\"studentName\": \"Enzo\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"Matemática\",\"score\":8.0},{\"name\":\"Lengua\",\"score\":6.0},{\"name\":\"Física\",\"score\":4.0}]}";


        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(test))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }


}
