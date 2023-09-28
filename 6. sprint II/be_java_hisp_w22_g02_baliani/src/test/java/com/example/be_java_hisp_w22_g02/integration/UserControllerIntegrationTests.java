package com.example.be_java_hisp_w22_g02.integration;

import com.example.be_java_hisp_w22_g02.dto.response.*;
import com.example.be_java_hisp_w22_g02.repository.Implementations.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static com.example.be_java_hisp_w22_g02.enums.ResponseMessages.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private UserRepositoryImpl userRepository;

    private static ObjectWriter mapper;

    @BeforeAll
    static void setUp() {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("Follow user integration test - Ok")
    void followUser_Ok_Test() throws Exception {

        int userId = 1;
        int userIdToFollow = 10;
        SuccessDTO expected = new SuccessDTO(SUCCESSFUL_FOLLOW.toString());
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Follow user integration test - Not found user id")
    void followUser_NotFoundUserId_Test() throws Exception {

        int userId = 999;
        int userIdToFollow = 10;
        ExceptionDto expected = new ExceptionDto(String.format(USER_ID_NOT_FOUND.toString(), userId));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Follow user integration test - Not found user id to follow")
    void followUser_NotFoundUserIdToFollow_Test() throws Exception {

        int userId = 1;
        int userIdToFollow = 999;
        ExceptionDto expected = new ExceptionDto(String.format(USER_ID_NOT_FOUND.toString(), userIdToFollow));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Follow user integration test - Follow twice")
    void followUser_FollowTwice_Test() throws Exception {

        int userId = 1;
        int userIdToFollow = 10;
        ExceptionDto expected = new ExceptionDto(FOLLOW_TWICE.toString());
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Follow user integration test - Same user id")
    void followUser_SameUserId_Test() throws Exception {

        int userId = 1;
        int userIdToFollow = 1;
        ExceptionDto expected = new ExceptionDto(SAME_USER_ID.toString());
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get followers integration test - Ok")
    void getFollowers_Ok_Test() throws Exception {

        int userId = 10;
        UserFollowerDTO expected = new UserFollowerDTO(10, "miguelito");
        UserFollowDTO userFollow = new UserFollowDTO(1, "pepito1234");
        expected.setFollowers(List.of(userFollow));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Get followers integration test - Not found")
    void getFollowers_NotFound_Test() throws Exception {

        int userId = 999;
        ExceptionDto expected = new ExceptionDto(String.format(USER_ID_NOT_FOUND.toString(), userId));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Get followed integration test - Ok")
    void getFollowedUser_Ok_Test() throws Exception {

        int userId = 1;
        UserFollowedDTO expected = new UserFollowedDTO(1, "pepito1234");
        UserFollowDTO userFollow = new UserFollowDTO(10, "miguelito");
        expected.setFollowed(List.of(userFollow));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Get followed integration test - Not found")
    void getFollowedUser_NotFound_Test() throws Exception {

        int userId = 999;
        ExceptionDto expected = new ExceptionDto(String.format(USER_ID_NOT_FOUND.toString(), userId));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Get followers count by userId integration test - Ok")
    void getFollowersCountByUserId_Ok_Test() throws Exception {

        int userId = 10;
        TotalFollowersDto expected = new TotalFollowersDto(userId, "miguelito", 1);
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Get followers count by userId integration test - Not found")
    void getFollowersCountByUserId_NotFound_Test() throws Exception {

        int userId = 999;
        ExceptionDto expected = new ExceptionDto(String.format(USER_ID_NOT_FOUND.toString(), userId));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Unfollow user integration test - Ok")
    void unfollowUser_Ok_Test() throws Exception{

        int userId = 15;
        int useridToUnfollow = 18;
        SuccessDTO expected = new SuccessDTO(SUCCESSFUL_UNFOLLOW.toString());
        String expectedString = mapper.writeValueAsString(expected);
        userRepository.followUser(userId, useridToUnfollow);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, useridToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Unfollow user integration test - Not found user id")
    void unfollowUser_NotFoundUserId_Test() throws Exception {

        int userId = 999;
        int userIdToUnfollow = 10;
        ExceptionDto expected = new ExceptionDto(String.format(USER_ID_NOT_FOUND.toString(), userId));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Unfollow user integration test - Not found user id to follow")
    void unfollowUser_NotFoundUserIdToUnfollow_Test() throws Exception {

        int userId = 1;
        int userIdToUnfollow = 999;
        ExceptionDto expected = new ExceptionDto(String.format(USER_ID_NOT_FOUND.toString(), userIdToUnfollow));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Unfollow user integration test - Not following")
    void unfollowUser_NotFollowing_Test() throws Exception {

        int userId = 8;
        int userIdToUnfollow = 10;
        ExceptionDto expected = new ExceptionDto(String.format(NOT_FOLLOWING_USER.toString(), userIdToUnfollow));
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Unfollow user integration test - Same user id")
    void unfollowUser_SameUserId_Test() throws Exception {

        int userId = 1;
        int userIdToUnfollow = 1;
        ExceptionDto expected = new ExceptionDto(SAME_USER_ID.toString());
        String expectedString = mapper.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedString, mvcResult.getResponse().getContentAsString());
    }





}
