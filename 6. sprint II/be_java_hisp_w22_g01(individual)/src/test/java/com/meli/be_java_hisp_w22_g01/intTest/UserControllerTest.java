package com.meli.be_java_hisp_w22_g01.intTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer= new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    @Test
    void countFollowers_OK() throws Exception {
        //Arrange
        CountFollowersDTO expected = new CountFollowersDTO(1,"Rick Harrison",2);

        //La request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1);

        //Lo expected
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));

        mockMvc.perform(request)
                .andExpect(contentExpected)
                .andDo(print());
    }

    @Test
    void countFollowers_NotFound() throws Exception {

        //La request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", 10);

        //Lo expected
        ResultMatcher contentExpected = status().isNotFound();

        mockMvc.perform(request)
                .andExpect(contentExpected)
                .andExpect(jsonPath("$.message").value("No se encontró el usuario con id: " + 10))
                .andDo(print());

    }
}
