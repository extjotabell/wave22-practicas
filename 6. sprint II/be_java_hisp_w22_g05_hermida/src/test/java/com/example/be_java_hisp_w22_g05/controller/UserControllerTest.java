package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.UserDto;
import com.example.be_java_hisp_w22_g05.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule()).writer();

    /**
     * Integration test to follow user successfully
     */

    @Test
    @DisplayName("Follow OK")
    void followUserOk() throws Exception {

        User user = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(2, "maria", new ArrayList<>(), new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", user.getId(), userToFollow.getId()))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(user.getId()))
                .andExpect(jsonPath("$.user_name").value(user.getName()));
    }

    /**
     * Integration test to check controller validations when attempting to follow a user
     */

    @Test
    @DisplayName("Follow error validaciones")
    void followUserValidationError() throws Exception {

        int id = 0;
        List<String> errorList = new ArrayList<>();
        errorList.add("El id del seguidor debe ser mayor a 0");
        errorList.add("El id del vendedor debe ser mayor a 0");

        JSONParser jsonParser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
        JSONArray jsonList =  (JSONArray) jsonParser.parse(writer.writeValueAsString(errorList));

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", id, id))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.messages").value(Matchers.containsInAnyOrder(jsonList.toArray())));
    }

    /**
     * Integration test to throw a bad request when a user tries to follow itself
     */
    @Test
    @DisplayName("No se puede seguir a sí mismo")
    void followSameUserError() throws Exception {

        User user = new User(1, "Carlos", new ArrayList<>(), new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", user.getId(), user.getId()))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no puede seguirse a si mismo!"));
    }

    /**
     * Integration test to throw a 404 when a user tries to follow a non-existing user
     */

    @Test
    @DisplayName("Follow usuario no existe")
    void followUserNotExists() throws Exception {

        User user = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", user.getId(), 100))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Uno de los usuarios no existe"));
    }

    /**
     * Integration test to successfully show a user's follower count
     */
    @Test
    @DisplayName("Follow count OK")
    void followersCountOk() throws Exception {
        User user = new User(1, "carlos", new ArrayList<>(), new ArrayList<>());
        int followersCount = 2;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", user.getId()))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(user.getId()))
                .andExpect(jsonPath("$.user_name").value(user.getName()))
                .andExpect(jsonPath("$.followers_count").value(followersCount));

    }

    /**
     * Integration test to check validations when attempting to get a user's follower count
     */
    @Test
    @DisplayName("Follow count error validaciones")
    void followersCountValidationError() throws Exception {

        int userId = 0;
        String errorMessage = "El id debe ser mayor a cero";

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.messages[0]").value(errorMessage));
    }

    /**
     * Integration test to throw a 404 when attempting to get a follower count from a non-existing user
     */
    @Test
    @DisplayName("Follow count usuario no existe")
    void followCountUserNotExists() throws Exception {
        int id = 100;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", id))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Usuario " + id + " no encontrado"));
    }

    /**
     * Integration test to successfully get users who follow a certain user
     */
    @Test
    @DisplayName("Obtener seguidos")
    void getUsersFollowedByOk() throws Exception {
        List<UserDto> followedList = new ArrayList<>();
        followedList.add(new UserDto(1, "carlos"));
        followedList.add(new UserDto(4, "javier"));

        JSONParser jsonParser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
        JSONArray jsonList =  (JSONArray) jsonParser.parse(writer.writeValueAsString(followedList));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 2))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followed").value(jsonList));

    }

    /**
     * Integration test to get users who follow a certain user with validation errors
     */
    @Test
    @DisplayName("Obtener seguidos error validaciones")
    void getUsersFollowedByValidationError() throws Exception {
        int userId = 0;
        String errorMessage = "El userId debe ser mayor que 0";
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.messages[0]").value(errorMessage));

    }

    /**
     * Integration test for when a user tries to get the followers of a non-existing user
     */
    @Test
    @DisplayName("Obtener seguidos usuario no existe")
    void getUsersFollowedByNotFound() throws Exception {
        int id = 100;
        String errorMessage = "No se encontró el usuario " + id;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", id))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(errorMessage));
    }

}
