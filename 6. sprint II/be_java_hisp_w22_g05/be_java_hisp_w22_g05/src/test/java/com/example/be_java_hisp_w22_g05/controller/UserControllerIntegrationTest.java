package com.example.be_java_hisp_w22_g05.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integration test for count followers")
    void getFollowersCountOkTest() throws Exception {
        final int userId = 1;
        final int expectedFollowersCount = 2;

        mockMvc.perform(get("/users/{userId}/followers/count", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(expectedFollowersCount));
    }

    @Test
    @DisplayName("Integration test for get followers list")
    void findUsersFollowingSellerOkTest() throws Exception {
        final int userId = 1;
        final int expectedUserFollowerId1 = 2;
        final int expectedUserFollowerId2 = 3;

        mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers.[0].user_id").value(expectedUserFollowerId1))
                .andExpect(jsonPath("$.followers.[1].user_id").value(expectedUserFollowerId2));
    }

    @Test
    @DisplayName("Integration test for get followed list")
    void getListOfUsersFollowedByOkTest() throws Exception {
        final int userId = 1;
        final int expectedUserFollowerId = 4;

        mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed.[0].user_id").value(expectedUserFollowerId));
    }
}
