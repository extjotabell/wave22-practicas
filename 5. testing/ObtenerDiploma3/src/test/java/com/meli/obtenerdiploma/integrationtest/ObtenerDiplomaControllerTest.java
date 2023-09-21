package com.meli.obtenerdiploma.integrationtest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScoreTestOk() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Student");
        student.setId(1L);
        student.setMessage("El alumno Student ha obtenido un promedio de 9.00. Felicitaciones!");
        student.setAverageScore(9.0);
        String stringifyStudent = TestUtilsGenerator.stringify(student);

        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L);

        // expected response
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(stringifyStudent);

        mockMvc.perform(request)
                .andExpect(expectedContent) // body
                .andExpect(expectedStatus) // status
                .andExpect(expectedContentType) // content type
                .andDo(print()); // ver request/response
    }
    @Test
    void analyzeScoreTestFail() throws Exception {
        // request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2L);

        // expected response
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 2 no se encuetra registrado.");

        mockMvc.perform(request)
                .andExpect(expectedContent) // body
                .andExpect(expectedStatus) // status
                .andExpect(expectedContentType) // content type
                .andDo(print()); // ver request/response
    }
}
