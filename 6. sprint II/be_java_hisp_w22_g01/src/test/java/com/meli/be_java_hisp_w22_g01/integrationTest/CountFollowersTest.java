package com.meli.be_java_hisp_w22_g01.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w22_g01.dto.response.CountFollowersDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CountFollowersTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    void getFollowersCountTest() throws Exception {

        // Arrange
        CountFollowersDTO countFollowersDTO = new CountFollowersDTO(1, "Rick Harrison", 2);

        // Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", "1");
        // Expected
        ResultMatcher contentTypeExpected = content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = content().json(
                this.writer.writeValueAsString(countFollowersDTO)
        );

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(contentTypeExpected)
                .andExpect(contentExpected)
                .andDo(print());

    }
}
