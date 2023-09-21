package com.meli.obtenerdiploma.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class
ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectWriter mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    @Test
    void analyzeScores() throws Exception {

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
}