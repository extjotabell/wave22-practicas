package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void analyzeScoresTest() throws Exception {

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.00. Puedes mejorar.", 7.0, List.of(
                new SubjectDTO("Matemática", 9D),
                new SubjectDTO("Física", 7D),
                new SubjectDTO("Química", 5D)
        ));

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(get("/analyzeScores/" + 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(studentDTO)))
                .andDo(print());
    }

    @Test
    @Order(2)
    void analyzeScoresFailTest() throws Exception {

        mockMvc.perform(get("/analyzeScores/" + 8))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    @Order(3)
    public void registerStudentOKTest() throws Exception {

        StudentDTO studentDTO = new StudentDTO(3L, "Carlos", null, null, List.of(
                new SubjectDTO("Matemática", 10D),
                new SubjectDTO("Física", 8D),
                new SubjectDTO("Química", 3D)
        ));

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Order(4)
    public void registerStudentFailTest() throws Exception {

        StudentDTO studentDTO = new StudentDTO(3L, null, null, null, List.of(
                new SubjectDTO("Matemática", 10D),
                new SubjectDTO("Física", 8D),
                new SubjectDTO("Química", 3D)
        ));

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(studentDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."))
                .andDo(print());
    }

    @Test
    @Order(5)
    public void findByIdOkTest() throws Exception {

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null, List.of(
                new SubjectDTO("Matemática", 9D),
                new SubjectDTO("Física", 7D),
                new SubjectDTO("Química", 5D)
        ));

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(get("/student/getStudent/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(studentDTO)))
                .andDo(print());

    }

    @Test
    @Order(6)
    public void findByIdFailTest() throws Exception {

        mockMvc.perform(get("/student/getStudent/8"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 8 no se encuetra registrado."))
                .andDo(print());
    }

    @Test
    @Order(7)
    public void modifyStudentOkTest() throws Exception {

        StudentDTO studentDTO = new StudentDTO(1L, "Lucas", null, null, List.of(
                new SubjectDTO("Matemática", 9D),
                new SubjectDTO("Física", 7D),
                new SubjectDTO("Química", 8D)
        ));

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(studentDTO))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Order(8)
    public void removeOkTest() throws Exception {

        mockMvc.perform(get("/student/removeStudent/3"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    @Order(9)
    public void listStudents() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        Set<StudentDTO> students = mapper.readValue(contentAsString, new TypeReference<>() {
        });
        Assertions.assertEquals(2, students.size());
    }


}
