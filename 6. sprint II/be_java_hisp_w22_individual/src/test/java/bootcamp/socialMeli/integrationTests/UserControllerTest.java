package bootcamp.socialMeli.integrationTests;

import bootcamp.socialMeli.dto.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US 0007 - unfollowUser OK")
    void unfollowUserOk() throws Exception {
        // ARRANGE
        int userIdWhoUnfollows = 5;
        int userIdToUnfollow = 6;

        // ACT & ASSERT
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdWhoUnfollows, userIdToUnfollow))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US 0007 - unfollowUser not following")
    void unfollowUserNotFollowing() throws Exception {
        // ARRANGE
        int userIdWhoUnfollows = 5;
        int userIdToUnfollow = 4;

        // ACT & ASSERT
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdWhoUnfollows, userIdToUnfollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("No sigue al usuario seleccionado"));
    }

    @Test
    @DisplayName("US 0007 - unfollowUser yourself")
    void unfollowUserWithOwnId() throws Exception {
        // ARRANGE
        int userIdWhoUnfollows = 5;
        int userIdToUnfollow = 5;

        // ACT & ASSERT
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdWhoUnfollows, userIdToUnfollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Los ids enviados son iguales"));
    }
}