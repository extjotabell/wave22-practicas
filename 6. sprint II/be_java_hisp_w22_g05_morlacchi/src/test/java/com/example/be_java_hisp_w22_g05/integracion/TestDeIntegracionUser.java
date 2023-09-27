package com.example.be_java_hisp_w22_g05.integracion;


import com.example.be_java_hisp_w22_g05.dto.UserDto;
import com.example.be_java_hisp_w22_g05.dto.UserFollowedDto;
import com.example.be_java_hisp_w22_g05.dto.UserFollowersDto;
import com.example.be_java_hisp_w22_g05.dto.UserNumberFollowersDto;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestDeIntegracionUser {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    @Test
    @DisplayName("US0001: follow")
    void follow() throws Exception{
        //ARRANGE
        UserFollowedDto expected = new UserFollowedDto(1,"carlos",List.of(new UserDto(4,"javier"), new UserDto(3,"pedro")));
        String result = mapper.writeValueAsString(expected);

        //ACT & ASSERTION
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(result));

    }

    @Test
    @DisplayName("US0002: getFollowersCount")
    void getFollowersCount() throws Exception {
        //ARRANGE
        UserNumberFollowersDto expected = new UserNumberFollowersDto(1,"carlos",2);
        String result = mapper.writeValueAsString(expected);

        //ACT & ASSERTION
        mockMvc.perform(get("/users/{userId}/followers/count",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(result));

    }

    @Test
    @DisplayName("US0003: findUsersFollowingSeller")
    void findUsersFollowingSeller() throws Exception{
        //ARRANGE
        UserFollowersDto expected = new UserFollowersDto(1,"carlos",List.of(new UserDto(3,"pedro")));
        String result = mapper.writeValueAsString(expected);

        //ACT & ASSERTION
        mockMvc.perform(get("/users/{userId}/followers/list",1).param("order","name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(result));
    }

    @Test
    @DisplayName("US0004: getListOfUsersFollowedBy")
    void getListOfUsersFollowedBy() throws Exception{
        //ARRANGER
        UserFollowedDto expected = new UserFollowedDto(1,"carlos",List.of(new UserDto(4,"javier"),new UserDto(3,"pedro")));
        String result = mapper.writeValueAsString(expected);

        //ACT & ASSERTION
        mockMvc.perform(get("/users/{userId}/followed/list",1).param("order","name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(result));
    }

    @Test
    @DisplayName("US0007: unfollow")
    void unfollow() throws Exception{
        //ARRANGER
        UserFollowedDto expected = new UserFollowedDto(2,"maria",List.of(new UserDto(4,"javier")));
        String result = mapper.writeValueAsString(expected);

        //ACT & ASSERTION
        mockMvc.perform(post("/users//{userId}/unfollow/{userIdToUnfollow}",2,1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(result));
    }
}
