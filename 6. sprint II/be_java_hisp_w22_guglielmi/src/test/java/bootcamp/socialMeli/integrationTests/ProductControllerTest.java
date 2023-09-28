package bootcamp.socialMeli.integrationTests;

import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US 0005 - addPost OK")
    void addPostOk() throws Exception {
        // ARRANGE
        int validSellerUserId = 6;
        ProductDto productDtoRequest = new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Red and Black", "Special Edition");
        PostDto postDtoRequest = new PostDto(validSellerUserId, null, LocalDate.now(), productDtoRequest, 100, 1500D);

        ObjectWriter writer = new ObjectMapper()
                                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                                    .writer();

        String payloadJson = writer.writeValueAsString(postDtoRequest);

        // ACT & ASSERT
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US 0005 - addPost user Not Found")
    void addPostUserNotFound() throws Exception {
        // ARRANGE
        int invalidSellerUserId = 10000;
        ProductDto productDtoRequest = new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Red and Black", "Special Edition");
        PostDto postDtoRequest = new PostDto(invalidSellerUserId, null, LocalDate.now(), productDtoRequest, 100, 1500D);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(postDtoRequest);

        // ACT & ASSERT
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Usuario con id #" + invalidSellerUserId + " no encontrado"));
    }
}