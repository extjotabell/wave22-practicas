package com.example.be_java_hisp_w22_g02.integration;

import com.example.be_java_hisp_w22_g02.dto.response.*;
import com.example.be_java_hisp_w22_g02.repository.Implementations.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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


}
