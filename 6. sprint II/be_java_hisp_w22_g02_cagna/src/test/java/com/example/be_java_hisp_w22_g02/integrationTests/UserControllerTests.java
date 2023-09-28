package com.example.be_java_hisp_w22_g02.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule()).writer();

    @Test
    void Post_FollowUser_OK() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("User followed successfully."));
    }
    @Test
    void Post_FollowUser_BadRequest() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 0,2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with id: 0 not found."));
    }
    @Test
    void Get_getFollowers_OK() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("pepito1234"));
    }
    @Test
    void Get_getFollowers_BadRequest() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/list", 1).queryParam("order", "hola"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }
    @Test
    void Get_getFollowed_OK() throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("pepito1234"));
    }
    @Test
    void Get_getFollowed_BadRequest() throws Exception{
        mockMvc.perform(get("/users/{userId}/followed/list", 1).queryParam("order", "hola"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }
    @Test
    void Get_getFollowersCountByUserId_OK() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("pepito1234"));
    }
    @Test
    void Get_getFollowersCountByUserId_BadRequest() throws Exception{
        mockMvc.perform(get("/users/{userId}/followers/count", 0))
                .andDo(print())
                .andExpect(status().isNotFound());

    }
    @Test
    void Post_Unfollow_OK() throws Exception{
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 5,4))
                .andDo(print())
                .andExpect(status().isOk());

    }





}
