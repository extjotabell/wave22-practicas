package com.w22_g03.be_java_hisp_w22_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    /**
     * This test method is used to verify the functionality of the "addPost" API endpoint.
     * It checks whether the endpoint successfully creates a post with the given data.
     *
     * @throws Exception if an error occurs during test execution.
     */
    @Test
    @DisplayName("Post of post should create a post Test")
    void addPostShouldCreateAPostOkTest() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand("Ferrari");
        productDTO.setProductId(1L);
        productDTO.setType("Car");
        productDTO.setName("F40");
        productDTO.setColor("red");

        PostDTO requestPostDTO = new PostDTO();
        requestPostDTO.setUserId(1L);
        requestPostDTO.setDate(LocalDate.now());
        requestPostDTO.setPrice(100.0);
        requestPostDTO.setCategory(1);
        requestPostDTO.setProduct(productDTO);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestPostDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.post_id").exists())
                .andExpect(jsonPath("$.post_id").value(1))
                .andDo(print());

    }

    /**
     * This test method is used to verify the behavior of the "addPost" API endpoint when attempting to create a post with a non-existing user.
     * It checks whether the endpoint correctly handles the scenario where the provided user ID does not correspond to an existing user.
     *
     * @throws Exception if an error occurs during test execution.
     */
    @Test
    @DisplayName("Post of post with non existing user should fail Test")
    void addPostWithNonExistingUserShouldFailTest() throws Exception {
        Long nonExistingUserId = 100L;
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand("Ferrari");
        productDTO.setProductId(1L);
        productDTO.setType("Car");
        productDTO.setName("F40");
        productDTO.setColor("red");

        PostDTO requestPostDTO = new PostDTO();
        requestPostDTO.setUserId(nonExistingUserId);
        requestPostDTO.setDate(LocalDate.now());
        requestPostDTO.setPrice(100.0);
        requestPostDTO.setCategory(1);
        requestPostDTO.setProduct(productDTO);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestPostDTO)))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User not found"))
                .andDo(print());

    }

    /**
     * This test method is used to verify the functionality of the "getFollowed" API endpoint.
     * It checks whether the endpoint returns the correct list of followed for a given user.
     *
     * @throws Exception if an error occurs during test execution.
     */
    @Test
    @DisplayName("Get followed should return the followed from a user Test")
    void getFollowedShouldReturnTheFollowedFromAUserOkTest() throws Exception {
        User follower = this.userRepository.findById(1L);
        User followed = this.userRepository.findById(2L);
        User anotherFollowed = this.userRepository.findById(3L);
        follower.getFollowed().add(followed);
        follower.getFollowed().add(anotherFollowed);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + follower.getUserId() + "/followed/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.followed.size()").value(2))
                .andDo(print());

    }

    /**
     * This test method is used to verify the functionality of the "getFollowers" API endpoint.
     * It checks whether the endpoint returns the correct list of followers for a given user.
     *
     * @throws Exception if an error occurs during test execution.
     */
    @Test
    @DisplayName("Get followers should return the followers from a user Test")
    void getFollowersShouldReturnTheFollowersFromAUserOkTest() throws Exception {
        User followed = this.userRepository.findById(1L);
        User follower = this.userRepository.findById(2L);
        User anotherFollower = this.userRepository.findById(3L);
        followed.getFollowers().add(follower);
        followed.getFollowers().add(anotherFollower);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + followed.getUserId() + "/followers/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.followers.size()").value(2))
                .andDo(print());

    }
}