package bootcamp.socialMeli.integrationTest;

import bootcamp.socialMeli.dto.FollowersCountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.fasterxml.jackson.databind.SerializationFeature.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private final ObjectWriter objectWriter = new ObjectMapper().configure(WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("IT - Follow user (OK)")
    void testFollowUserOK() throws Exception {
        mockMvc.perform(
                post("/users/{userId}/follow/{userIdToFollow}",1,7))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("IT - Follow self user (Exception)")
    void testFollowSelf() throws Exception {
        mockMvc.perform(
                        post("/users/{userId}/follow/{userIdToFollow}",1,1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("IDs enviados iguales"));
    }

    @Test
    @DisplayName("IT - Test unfollow (OK)")
    void testUnfollowOk() throws Exception {
        mockMvc.perform(
                post("/users/{userId}/unfollow/{userIdToUnfollow}",2,7))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Se dejó de seguir al usuario 7"));
    }

    @Test
    @DisplayName("IT - Test unfollow unexisting user (Exception)")
    void testUnfollowUnexistingUser() throws Exception {
        mockMvc.perform(
                        post("/users/{userId}/unfollow/{userIdToUnfollow}",2,-4))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with ID #-4 not found"));
    }

    @Test
    @DisplayName("IT - Get followers count (OK)")
    void getFollowersCountOK() throws Exception {

        FollowersCountDto expectedFollowerCount = new FollowersCountDto(6, "Jesica", 2);
        String expectedBody = objectWriter.writeValueAsString(expectedFollowerCount);

        mockMvc.perform(
                get("/users/{userId}/followers/count", 6))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedBody));
    }

    @Test
    @DisplayName("IT - Get followers count user not found (exception)")
    void getFollowersCountUserNotFound() throws Exception {
        mockMvc.perform(
                        get("/users/{userId}/followers/count", -4))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with ID #-4 not found"));
    }

    @Test
    @DisplayName("IT - Get followed list (OK)")
    void getFollowedList() throws Exception {
        mockMvc.perform(
                get("/users/{userId}/followed/list",2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followed").exists());
    }
}
