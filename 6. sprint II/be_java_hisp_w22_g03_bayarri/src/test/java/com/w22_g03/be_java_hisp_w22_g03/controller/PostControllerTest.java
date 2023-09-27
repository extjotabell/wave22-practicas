package com.w22_g03.be_java_hisp_w22_g03.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.UserFollowedSellersPostsDTO;
import com.w22_g03.be_java_hisp_w22_g03.service.PostService;
import com.w22_g03.be_java_hisp_w22_g03.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class PostControllerTest {

    @MockBean
    private PostService postService;

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    /**
     * This parameterized test method verifies the behavior of the `getFollowedUsersPostsById` endpoint in the `ProductController` class.
     * It tests various invalid values for the 'order' query parameter to ensure that the endpoint returns a Bad Request (400) response
     * with a specific error message when an invalid order value is provided.
     *
     * @param order A String representing the value of the 'order' query parameter, which is expected to be invalid.
     * @throws Exception If any errors occur during the test execution.
     */
    @ParameterizedTest
    @ValueSource(strings = {"date", "name", "date_a", "date_d"})
    @DisplayName("Invalid order param")
    void checkOrderParamFailTest(String order) throws Exception {

        // Arrange
        Long userId = 1L;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errors[0]").value("Orden no válido, Solamente acepta date_asc o date_desc"))
                .andDo(print());

    }

    /**
     * This parameterized test method verifies the behavior of the `getFollowedUsersPostsById` endpoint in the `ProductController` class.
     * It tests the endpoint with valid values for the 'order' query parameter and ensures that it returns an OK (200) response
     * containing the expected JSON response.
     *
     * @param order A String representing a valid value for the 'order' query parameter.
     * @throws Exception If any errors occur during the test execution.
     */
    @ParameterizedTest
    @ValueSource(strings = {"date_asc", "date_desc"})
    @DisplayName("Valid order param")
    void checkOrderParamOkTest(String order) throws Exception {

        //Arrange
        UserFollowedSellersPostsDTO fakeResponse = new UserFollowedSellersPostsDTO();
        fakeResponse.setUserId(1);
        fakeResponse.setPosts(List.of(
                new PostDTO(1L, 1L, LocalDate.now(), new ProductDTO(), 56, 1000.0)
        ));

        when(postService.getFollowedUsersPostsById(anyLong(), anyString())).thenReturn(fakeResponse);

        Long userId = 1L;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(fakeResponse)))
                .andDo(print());

    }
}