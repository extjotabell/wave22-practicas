package bootcamp.socialMeli.integrationTests.userController;
import bootcamp.socialMeli.dto.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integration test US 7 - ok (validated user)")
    void unfollowIntegrationTest() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",1,6))
                .andExpect(status().isOk())
                .andExpect(content().string("Se dejó de seguir al usuario 6"))
                .andReturn();
    }
    @Test
    @DisplayName("Integration test US 7 - not ok (non existing user)")
    void unfollowInvalidUserIntegrationTest() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",1,100))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User with ID #100 not found"))
                .andReturn();
    }

    @Test
    @DisplayName("Integration test US 3 - ok")
    void getFollowersListIntegrationTest() throws Exception {

        List<UserDto> emptyList = new ArrayList<>();
        mockMvc.perform(get("/users/{userId}/followers/list",1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers").value(emptyList))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Diego"))
                .andReturn();
    }

    @Test
    @DisplayName("Integration test US 3 - ok")
    void getFollowedListIntegrationTest() throws Exception {

        List<UserDto> emptyList = new ArrayList<>();
        mockMvc.perform(get("/users/{userId}/followed/list",1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Diego"))
                .andReturn();
    }
    @Test
    @DisplayName("Integration test endpoint getAllUsers")
    void getAllUsersIntegrationTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn();
    }

}

