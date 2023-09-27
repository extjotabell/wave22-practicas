package com.w22_g03.be_java_hisp_w22_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.w22_g03.be_java_hisp_w22_g03.dto.FollowedDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationTest {

    UserDTO followed;
    ProductDTO productDTO;
    PostDTO postDTO;
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        followed = new UserDTO(2, "Bruno");
        productDTO = new ProductDTO();
        productDTO.setProductId(1L);
        productDTO.setBrand("BM");
        productDTO.setType("Bueno");
        productDTO.setName("Producton");
        productDTO.setColor("Rojo");
        productDTO.setNotes("Este es el mejor producto del mundo");

        postDTO = new PostDTO();
        postDTO.setUserId(2L);
        postDTO.setDate(LocalDate.now());
        postDTO.setCategory(1);
        postDTO.setPrice(100.0);
        postDTO.setProduct(productDTO);

        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    /**
     * This integration test calls /users/{user_id}/followed/list endpoint and checks
     * that a user that follows one user returns a FollowedDTO with one user followed.
     * It requires to make another user a seller, and start following that user.
     * @throws Exception
     */
    @Test
    @DisplayName("FollowedDTO With One Followed OK")
    void getFollowedDTOListOkTest() throws Exception{
        //Arrange
        String jsonPayload = mapper.writeValueAsString(postDTO);
        FollowedDTO expectedFollowedDTOWithOne = new FollowedDTO(1, "Alejandro", List.of(followed));

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"))
                .andExpect(status().isOk());

        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followed/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //Assert
        Assertions.assertEquals(mapper.writeValueAsString(expectedFollowedDTOWithOne), result.getResponse().getContentAsString());
    }

    /**
     * This integration test calls /users/{user_id}/followed/list endpoint and checks
     * that a user that follows no one returns a FollowedDTO with zero users followed.
     * @throws Exception
     */
    @Test
    @DisplayName("FollowedDTO With Zero Followed OK")
    void getFollowedDTOEmptyListOkTest() throws Exception{
        //Arrange
        String jsonPayload = mapper.writeValueAsString(postDTO);
        FollowedDTO expectedFollowedDTOWithZero = new FollowedDTO(1, "Alejandro", List.of());

        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followed/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //Assert
        Assertions.assertEquals(mapper.writeValueAsString(expectedFollowedDTOWithZero), result.getResponse().getContentAsString());
    }

    //US0005
    /**
     * This test verifies that the /products/post POST endpoint returns the response PostDTO expected.
     * It requires another PostDTO in body. This postDTO cant have postId.
     * @throws Exception
     */
    @Test
    @DisplayName("Post OK")
    void postOkTest() throws Exception{
        // Arrange
        String jsonPayload = mapper.writeValueAsString(postDTO);
        postDTO.setPostId(1L);
        String expected = mapper.writeValueAsString(postDTO);

        // Act
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }
}
