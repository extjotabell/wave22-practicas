package com.w22_g03.be_java_hisp_w22_g03.integration;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void getFollowedListOk () throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list", 1))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id").value(4));
    }

    @Test
    @Order(2)
    void getFollowedList_NotFound () throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list", 8))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User not found"));
    }
    @Test
    @Order(3)
    void countFollowersOk () throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 3))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(1));
    }

    @Test
    @Order(3)
    void countFollowers_DontHave () throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(0));
    }

    @Test
    @Order(3)
    void countFollowers_UserNotExist () throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 8))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User not found"));
    }

    @Test
    @Order(3)
    void getFollowersList_UserNotFound () throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list", 8))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User not found"));
    }

    @Test
    @Order(3)
    void getFollowersListOk () throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list", 3))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value(1));
    }

    @Test
    @Order(4)
    void unFollowOk () throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 4))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("1 successfully unfollowed 4"));
    }

    @Test
    @Order(4)
    void unFollow_SameUser () throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 1))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User can't unfollow themselves."))
                .andDo(print());
    }

    @Test
    @Order(4)
    void unFollow_UserNotFound () throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 8))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User not found"))
                .andDo(print());
    }

    @Test
    @Order(4)
    void unFollow_UserIsNotFollower () throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 1))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("You are not a follower of this user."))
                .andDo(print());
    }
}
