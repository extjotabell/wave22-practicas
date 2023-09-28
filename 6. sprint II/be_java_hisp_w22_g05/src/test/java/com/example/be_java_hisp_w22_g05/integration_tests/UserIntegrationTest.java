package com.example.be_java_hisp_w22_g05.integration_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integration US-0003 Endpoint - Obtain users list followers by user id")
    void getListOfUsersFollowedByOKTest() throws Exception {

        mockMvc.perform(get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.user_name").value("carlos"))
                .andExpect(jsonPath("$.followed.[0].user_id").value("4"))
                .andExpect(jsonPath("$.followed.[0].user_name").value("javier"));
    }




}
