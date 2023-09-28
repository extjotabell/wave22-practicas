package bootcamp.socialMeli.integrationTests;

import bootcamp.socialMeli.dto.FollowersCountDto;
import bootcamp.socialMeli.dto.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("US 01 - Get users")
    public void testGetUsers() throws Exception {
        // Arrange
        UserDto user1 = new UserDto(1, "Diego");
        UserDto user2 = new UserDto(2, "Florencia");
        UserDto user3 = new UserDto(3, "Sergio");

        List<UserDto> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // Act  & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].user_name").value("Diego"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].user_name").value("Florencia"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].user_name").value("Sergio"));;

    }

    @Test
    @DisplayName("US 01 - Follow user")
    public void testFollowUser() throws Exception {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;

        // Act  & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("US 02 - Get Followers Count")
    public void testGetFollowersCount() throws Exception {
        // Arrange
        int userId = 7;

        FollowersCountDto followersCountDto = new FollowersCountDto(userId, "Daniel", 3);

        // Act  & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(followersCountDto.getUserId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value(followersCountDto.getUserName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(followersCountDto.getFollowersCount()));
    }

    @Test
    @DisplayName("US 07 - Unfollow User")
    void unfollowUserOk() throws Exception {
        // Arrange
        int userId = 5;
        int userIdToUnfollow = 7;

        // Act  & Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isOk());
    }

}

