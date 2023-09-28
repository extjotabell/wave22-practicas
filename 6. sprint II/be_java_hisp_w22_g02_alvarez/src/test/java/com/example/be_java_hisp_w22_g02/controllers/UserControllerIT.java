package com.example.be_java_hisp_w22_g02.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Nested;
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


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Nested
    class FollowUser {
        @Test
        void shouldFollowUser() throws Exception {
            // ARRANGE & ACT
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/1/follow/2");
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

            // ASSERT
            mockMvc.perform(request)
                    .andExpect(expectedStatus)
                    .andExpect(contentTypeExpected)
                    .andDo(MockMvcResultHandlers.print());
        }

        @Test
        void shouldGetFollowersList() throws Exception{
            // ARRANGE & ACT
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/1/followers/list");
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

            // ASSERT
            mockMvc.perform(request)
                    .andExpect(expectedStatus)
                    .andExpect(contentTypeExpected)
                    .andDo(MockMvcResultHandlers.print());
        }

        @Test
        void shouldGetFollowedList() throws Exception{
            // ARRANGE & ACT
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/1/followed/list");
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

            // ASSERT
            mockMvc.perform(request)
                    .andExpect(expectedStatus)
                    .andExpect(contentTypeExpected)
                    .andDo(MockMvcResultHandlers.print());
        }

        @Test
        void shouldGetQuantityOfFollowers() throws Exception {
            // ARRANGE & ACT
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/1/followers/count");
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

            // ASSERT
            mockMvc.perform(request)
                    .andExpect(expectedStatus)
                    .andExpect(contentTypeExpected)
                    .andExpect(MockMvcResultMatchers.jsonPath("$.followersCount").value(0))
                    .andDo(MockMvcResultHandlers.print());

        }

    }

    @Nested
    class UnfollowUser {
        @Test
        void shouldReturnExceptionWhenUnfollowUserWhoNotFollow() throws Exception {
            // ARRANGE & ACT
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/1/unfollow/2");
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();
            ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

            // ASSERT
            mockMvc.perform(request)
                    .andExpect(expectedStatus)
                    .andExpect(contentTypeExpected)
                    .andDo(MockMvcResultHandlers.print());
        }
    }
}
