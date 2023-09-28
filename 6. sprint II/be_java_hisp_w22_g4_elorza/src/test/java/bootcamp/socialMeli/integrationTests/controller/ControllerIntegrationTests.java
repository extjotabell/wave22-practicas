package bootcamp.socialMeli.integrationTests.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void unfollowIntegrationTest() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",1,6))
                .andExpect(status().isOk())
                .andExpect(content().string("Se dejó de seguir al usuario 6"))
                .andReturn();

    }

}

