package com.w22_g03.be_java_hisp_w22_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.w22_g03.be_java_hisp_w22_g03.dto.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * Integration test for the followersCount endpoint.
     *
     * This test verifies that the 'followersCount' endpoint correctly returns the number
     * of followers for a given user. It sets up the expected result, performs an HTTP GET
     * request to the endpoint, and compares the response to the expected JSON representation
     * of the number of followers.
     */
    @Test
    @DisplayName("Get followersCount of given user ok")
    void followersCount () throws Exception{
        //Arrange
        Integer userId = 1;
        NumberOfFollowersDTO expected = new NumberOfFollowersDTO(1,"Alejandro", 0);
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = mapper.writeValueAsString(expected);
        //Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        //Assert
        assertEquals(expectedJson,mvcResult.getResponse().getContentAsString());
    }

    /**
     * Parameterized integration test for the followersList endpoint.
     *
     * This test verifies that the 'followersList' endpoint correctly returns a list of followers
     * for a given user, sorted based on the provided order. It sets up the expected result,
     * performs an HTTP GET request to the endpoint with the specified order parameter,
     * and compares the response to the expected JSON representation of the follower list.
     * @param order the sorting order for the followers list
     */
    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc"})
    @DisplayName("Get followers list of given user ordered ok")
    void followersList (String order) throws Exception{
        //Arrange
        Integer userId = 1;
        FollowerDTO expected = new FollowerDTO(1, "Alejandro",new ArrayList<>());
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = mapper.writeValueAsString(expected);
        //Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",userId).param("order",order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        //Assert
        assertEquals(expectedJson,mvcResult.getResponse().getContentAsString());
    }

    /**
     * Parameterized integration test for the followedList endpoint.
     *
     * This test verifies that the 'followedList' endpoint correctly returns a list of users
     * followed by a given user, sorted based on the provided order. It sets up the expected result,
     * performs an HTTP GET request to the endpoint with the specified order parameter,
     * and compares the response to the expected JSON representation of the followed user list.
     *
     * @param order the sorting order for the followed list
     */
    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc"})
    @DisplayName("Get followed list of given user ordered ok")
    void followedList (String order) throws Exception{
        //Arrange
        Integer userId = 1;
        FollowedDTO expected = new FollowedDTO(1, "Alejandro",new ArrayList<>());
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = mapper.writeValueAsString(expected);
        //Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",userId).param("order",order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        //Assert
        assertEquals(expectedJson,mvcResult.getResponse().getContentAsString());
    }

    /**
     * Integration test for the addPost endpoint.
     *
     * This test verifies that the 'addPost' endpoint correctly adds a new post to the collection.
     * It sets up the expected result, creates a POST request with a JSON payload representing the new post,
     * and compares the response to the expected JSON representation of the added post.
     */

    @Test
    @DisplayName("Add new post ok")
    void addPost() throws Exception{
        //Arrange
        ProductDTO productDTO = new ProductDTO(1L,"Mesa","Mueble","Mercado Libre","Blanco",null);
        PostDTO newPost = new PostDTO(null,1L, LocalDate.now(),productDTO,1,1500D);
        PostDTO expected = new PostDTO(1L,1L, LocalDate.now(),productDTO,1,1500D);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String payload = mapper.writeValueAsString(newPost);
        String expectedJson = mapper.writeValueAsString(expected);

        //Act
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        . contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        //Assert
        assertEquals(expectedJson,mvcResult.getResponse().getContentAsString());
    }

}
