package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;
import com.example.be_java_hisp_w22_g05.utils.UserGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    @Test
    void testFollowOk() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 4, 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void testFollowersCount() throws Exception {
        //Arrange
        Integer userId = 1;
        UserNumberFollowersDto expected = new UserNumberFollowersDto(1,"carlos", 2);

        String expectedJson = mapper.writeValueAsString(expected);
        //Act
        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count",userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        //Assert
        assertEquals(expectedJson,mvcResult.getResponse().getContentAsString());
    }


    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc"})
    void testListOfUsersFollowedByOk(String order) throws Exception {
        // ARRANGE
        int userId = 4;
        String expectedJsonResponse = mapper.writeValueAsString(
                order.equals("name_asc") ? UserGenerator.getUserFollowedDtoListAsc() : UserGenerator.getUserFollowedDtoListDesc()
        );
        // ACT
        MvcResult mvcResult =  mockMvc.perform(get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // ASSERT
        assertEquals(expectedJsonResponse, mvcResult.getResponse().getContentAsString());
    }
    @Test
    void testUnfollowOk() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnFollow}", 2,3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc"})
    void testFindUsersFollowingSellerOk(String order) throws Exception {
        // ARRANGE
        int userId = 4;
        String expectedJsonResponse = mapper.writeValueAsString(
                order.equals("name_asc") ? UserGenerator.getUserFollowerDtoListAsc() : UserGenerator.getUserFollowerDtoListDesc()
        );
        // ACT
        MvcResult mvcResult =  mockMvc.perform(get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // ASSERT
        assertEquals(expectedJsonResponse, mvcResult.getResponse().getContentAsString());
    }
}