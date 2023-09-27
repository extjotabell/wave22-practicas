package com.w22_g03.be_java_hisp_w22_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w22_g03.be_java_hisp_w22_g03.dto.NumberOfFollowersDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import com.w22_g03.be_java_hisp_w22_g03.model.Post;
import com.w22_g03.be_java_hisp_w22_g03.model.Product;
import com.w22_g03.be_java_hisp_w22_g03.model.User;
import com.w22_g03.be_java_hisp_w22_g03.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private User seller;

    @BeforeEach
    void setUp() {

        Product product = new Product();
        product.setBrand("brand");
        product.setProductId(1L);
        product.setType("type");
        product.setProductName("product");
        product.setColor("red");

        Post post = new Post();
        post.setDate(LocalDate.now());
        post.setPrice(12560.69);
        post.setCategory(3);
        post.setProduct(product);
        product.setPost(post);

        seller = userRepository.findById(1L);
        post.setUser(seller);
        seller.getPosts().add(post);

        User user = userRepository.findById(2L);
        user.getFollowed().add(seller);
        seller.getFollowers().add(user);
    }

    @AfterEach
    void tearDown() {
        User otherUser = this.seller.getFollowers().get(0);
        otherUser.getFollowed().remove(seller);
        seller.getFollowers().remove(otherUser);
        seller.getPosts().remove(0);
    }

    /**
     * This is a unit test method that tests the behavior of the "add post" endpoint in the
     * controller class. It simulates an HTTP POST request to the "/products/post" endpoint
     * with a JSON request body containing a product post DTO. The test verifies that the
     * response status is HTTP OK (200), the content type is JSON, and that the response JSON
     * contains a "post_id" field.
     *
     * @throws Exception if there is an unexpected error during test execution.
     */
    @Test
    @DisplayName("Add post Ok Test")
    void addPostOkTest() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand("brand");
        productDTO.setProductId(1L);
        productDTO.setType("type");
        productDTO.setName("product");
        productDTO.setColor("red");

        PostDTO requestPostDTO = new PostDTO();
        requestPostDTO.setUserId(1L);
        requestPostDTO.setDate(LocalDate.now());
        requestPostDTO.setPrice(12560.69);
        requestPostDTO.setCategory(3);
        requestPostDTO.setProduct(productDTO);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestPostDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.post_id").exists())
                .andDo(print());

    }

    /**
     * This is a unit test method that tests the behavior of the "add post" endpoint in the
     * controller class when the user is not found. It simulates an HTTP POST request to the
     * "/products/post" endpoint with a JSON request body containing a product post DTO.
     * The test verifies that the response status is HTTP Not Found (404), the content type is
     * JSON, and that the response JSON contains a "message" field with the value "User not found".
     *
     * @throws Exception if there is an unexpected error during test execution.
     */
    @Test
    @DisplayName("Add post Fail Test")
    void addPostUserNotFoundTest() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand("brand");
        productDTO.setProductId(1L);
        productDTO.setType("type");
        productDTO.setName("product");
        productDTO.setColor("red");

        PostDTO requestPostDTO = new PostDTO();
        requestPostDTO.setUserId(8L);
        requestPostDTO.setDate(LocalDate.now());
        requestPostDTO.setPrice(12560.69);
        requestPostDTO.setCategory(3);
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
     * This is a unit test method that tests the behavior of the "add post" endpoint in the
     * controller class when there is a validation error in the request. It simulates an HTTP
     * POST request to the "/products/post" endpoint with a JSON request body containing a
     * product post DTO that has a price exceeding the maximum allowed price. The test verifies
     * that the response status is HTTP Bad Request (400), the content type is JSON, and that
     * the response JSON contains an "errors" array with a validation error message.
     *
     * @throws Exception if there is an unexpected error during test execution.
     */
    @Test
    @DisplayName("Add post Fail Test")
    void addPostValidationErrorTest() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand("brand");
        productDTO.setProductId(1L);
        productDTO.setType("type");
        productDTO.setName("product");
        productDTO.setColor("red");

        PostDTO requestPostDTO = new PostDTO();
        requestPostDTO.setUserId(8L);
        requestPostDTO.setDate(LocalDate.now());
        requestPostDTO.setPrice(10000000.01);
        requestPostDTO.setCategory(3);
        requestPostDTO.setProduct(productDTO);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestPostDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errors[0]").value("El precio máximo por producto es de 10.000.000"))
                .andDo(print());

    }

    /**
     * This is a unit test method that tests the behavior of the "add post" endpoint in the
     * controller class when the HTTP request message is not readable due to invalid JSON.
     * It simulates an HTTP POST request to the "/products/post" endpoint with an invalid JSON
     * payload that contains a non-numeric value for "user_id." The test verifies that the
     * response status is HTTP Bad Request (400), the content type is JSON, and that the response
     * JSON contains a "message" field indicating that the request contains invalid field values.
     *
     * @throws Exception if there is an unexpected error during test execution.
     */
    @Test
    @DisplayName("Add post Fail Test")
    void addPostHttpMessageNotReadableTest() throws Exception {

        String payload = """
                {
                  "user_id": a,
                  "date": "05-09-2023",
                  "product": {
                    "product_id" : 1,
                    "product_name": "product",
                    "type" : "algo",
                    "brand" : "brand",
                    "color" : "blue",
                    "notes" : "sl"
                  },
                  "category": 11,
                  "price": 1000
                }""";

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("The request contains invalid field values"))
                .andDo(print());

    }

    /**
     * This is a unit test method that tests the behavior of the "Amount of Followers" endpoint
     * in the controller class when the request is successful. It simulates an HTTP GET request
     * to the "/users/1/followers/count" endpoint, and the test verifies that the response status
     * is HTTP OK (200), the content type is JSON, and that the response JSON matches the expected
     * NumberOfFollowersDTO object.
     *
     * @throws Exception if there is an unexpected error during test execution.
     */
    @Test
    @DisplayName("Amount of Followers Ok Test")
    void testAmountOfFollowersForSellerOk() throws Exception {

        NumberOfFollowersDTO expected = new NumberOfFollowersDTO(1, "Alejandro", 1);

        mockMvc.perform(get("/users/1/followers/count"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(expected)))
                .andDo(print());
    }

    /**
     * This is a unit test method that tests the behavior of the "Followers" endpoint in the
     * controller class when the request is successful. It simulates an HTTP GET request to the
     * "/users/1/followers/list" endpoint, and the test verifies that the response status is
     * HTTP OK (200), the content type is JSON, and that the response JSON contains a "followers"
     * array with at least one follower.
     *
     * @throws Exception if there is an unexpected error during test execution.
     */
    @Test
    @DisplayName("Followers Ok Test")
    void getFollowersOkTest() throws Exception {

        mockMvc.perform(get("/users/1/followers/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.followers.size()").value(1))
                .andDo(print());

    }

}
