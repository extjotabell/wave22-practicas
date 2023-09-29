package bootcamp.socialMeli.integrationTests;

import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US 01 - Follow user - Ok")
    void followUserTestOk() throws Exception
    {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 9)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("US 01 - Follow user - Already follow user")
    void followUserTestFailAlreadyFollowingUser() throws Exception
    {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 8)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("Ya sigue al usuario"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof BadRequestException))
                .andReturn();
    }

    @Test
    @DisplayName("US 01 - Follow user - Already follow user")
    void followUserTestFailTryFollowSameUser() throws Exception
    {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("IDs enviados iguales"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof BadRequestException))
                .andReturn();
    }

    @Test
    @DisplayName("US 01 - Follow user - User is COMPRADOR")
    void followUserTestFailFollowComprador() throws Exception
    {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",2, 5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("Intentando seguir un COMPRADOR"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof BadRequestException))
                .andReturn();
    }

    @Test
    @DisplayName("US 01 - Follow user - User Not Found")
    void followUserTestFailUserNotFound() throws Exception
    {
        mockMvc.perform(post("/users//{userId}/follow/{userIdToFollow}", 20, 5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("User with ID #20 not found"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof NotFoundException))
                .andReturn();
    }

    @Test
    @DisplayName("US 01 - Follow user - Try follow same user id")
    void followUserTestFailTryfollowSameUser() throws Exception
    {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 5, 5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("IDs enviados iguales"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof BadRequestException))
                .andReturn();
    }

    @Test
    @DisplayName("US 02 - Followers count - Ok")
    void getFollowersCountTestOk() throws Exception
    {
        mockMvc.perform(get("/users/{userId}/followers/count", 6)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id")
                        .value(6))
                .andExpect(jsonPath("$.user_name")
                        .value("Jesica"))
                .andExpect(jsonPath("$.followers_count")
                        .value(2))
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("US 02 - Followers count - User Not Found")
    void getFollowersCountTestFailUserNotFound() throws Exception
    {
        mockMvc.perform(get("/users/{userId}/followers/count", 20)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof NotFoundException))
                .andReturn();
    }
    @Test
    @DisplayName("US 03 - Followers list - Ok")
    void getFollowersListTestOk() throws Exception
    {
        mockMvc.perform(get("/users/{userId}/followers/list", 5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id")
                        .value(5))
                .andExpect(jsonPath("$.user_name")
                        .value("Soledad"))
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("US 03 - Followers list - User Not Found")
    void getFollowersListTestFailUserNotFound() throws Exception
    {
        mockMvc.perform(get("/users/{userId}/followers/list", 20)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("User with ID #20 not found"))
                .andExpect(content().contentType("application/json"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof NotFoundException))
                .andReturn();
    }

    @Test
    @DisplayName("US 04 - Followed list - Ok")
    void getFollowedListTestOk() throws Exception
    {
        mockMvc.perform(get("/users/{userId}/followed/list", 5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id")
                        .value(5))
                .andExpect(jsonPath("$.user_name")
                        .value("Soledad"))
                .andReturn();
    }

    @Test
    @DisplayName("US 04 - Followed list - User Not Found")
    void getFollowedListTestFailUserNotFound() throws Exception
    {
        mockMvc.perform(get("/users/{userId}/followed/list", 20)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("User with ID #20 not found"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof NotFoundException))
                .andReturn();
    }

    @Test
    @DisplayName("US 07 - Unfollow user - Ok")
    void unfollowUserTestOk() throws Exception
    {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 7)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Se dejó de seguir al usuario 7"))
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US 07 - User not Found - Ok")
    void unfollowUserTestFailUserNotFound() throws Exception
    {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 20, 5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("User with ID #20 not found"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof NotFoundException))
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US 07 - Unfollow user - Not follow user")
    void unfollowUserTestFailNotFolllowUser() throws Exception
    {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("No sigue al usuario seleccionado"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof BadRequestException))
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("US 07 - Unfollow user - Try unfollow same user id")
    void unfollowUserTestFailTryUnfollowSameUser() throws Exception
    {
        mockMvc.perform(post("/users/2/unfollow/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("Los ids enviados son iguales"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof BadRequestException))
                .andDo(print())
                .andReturn();
    }
}