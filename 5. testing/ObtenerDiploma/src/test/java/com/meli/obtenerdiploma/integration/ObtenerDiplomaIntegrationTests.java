package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTests {

    static StudentDAO studentDAO = new StudentDAO();

    @Autowired
    MockMvc mockMvc;

    private StudentDTO studentDTO;

    private static ObjectWriter mapper;

    @BeforeAll
    static void setUp() {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    void addStudent() {
        studentDTO = TestUtils.getMockStudent("Nicolas");
        if (!studentDAO.exists(studentDTO))
            studentDAO.save(studentDTO);

    }

    @Test
    void testAnalyzeScoreOkIntegrationTest() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(mapper.writeValueAsString(studentDTO), mvcResult.getResponse().getContentAsString());

    }

    @Test
    void testAnalyseScoreNotFoundExceptionIntegrationTest() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 999L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }
}
