package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    void analyzeScore() throws Exception {
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matemática", 9.0));
        subjectList.add(new SubjectDTO("Lengua", 7.0));

        StudentDTO request = new StudentDTO("Juan", "", 0.0, subjectList);
        StudentDTO expected = new StudentDTO("Juan", "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.", 8.0, subjectList);

        String payload = writer.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/analyzeScores").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.averageScore").value(expected.getAverageScore()))
                .andExpect(jsonPath("$.message").value(expected.getMessage()));
    }

    @Test
    void analyzeScoreNotOk() throws Exception{
        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(new SubjectDTO("Matemática", 9.0));
        subjectList.add(new SubjectDTO("Lengua", 7.0));

        StudentDTO request = new StudentDTO("Juan", "", 0.0, null);
        StudentDTO expected = new StudentDTO("Juan", "El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.", 8.0, subjectList);

        String payload = writer.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/analyzeScores").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0]").value("La lista de materias no puede estar vacía"));
    }

}
