package com.meli.be_java_hisp_w22_g01.integrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class Root {


    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Directorio raiz")
    void main() throws Exception{

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

        ResultMatcher statusExpect = MockMvcResultMatchers.status().isNotFound();

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpect)
                .andDo(MockMvcResultHandlers.print());
    }


}
