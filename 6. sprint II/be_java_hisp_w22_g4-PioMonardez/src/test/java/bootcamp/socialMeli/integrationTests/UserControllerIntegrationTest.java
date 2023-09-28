package bootcamp.socialMeli.integrationTests;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;

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
    void followUserTestOk() throws Exception
    {
        mockMvc.perform(post("/users/2/follow/9")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void followUserTestFailAlreadyFollowingUser() throws Exception
    {
        mockMvc.perform(post("/users/2/follow/8")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("Ya sigue al usuario"))
                .andReturn();
    }

    @Test
    void followUserTestFailFollowComprador() throws Exception
    {
        mockMvc.perform(post("/users/2/follow/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("Intentando seguir un COMPRADOR"))
                .andReturn();
    }

    @Test
    void followUserTestFailUserNotFound() throws Exception
    {
        mockMvc.perform(post("/users/20/follow/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("User with ID #20 not found"))
                .andReturn();
    }

    @Test
    void getFollowersCountTestOk() throws Exception
    {
        mockMvc.perform(get("/users/5/followers/list")
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
    void getFollowersCountTestFailUserNotFound() throws Exception
    {
        mockMvc.perform(get("/users/20/followers/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("User with ID #20 not found"))
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

}
