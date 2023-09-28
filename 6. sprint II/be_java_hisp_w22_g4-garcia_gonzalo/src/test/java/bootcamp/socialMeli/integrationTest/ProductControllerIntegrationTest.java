package bootcamp.socialMeli.integrationTest;

import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectWriter objectWriter = new ObjectMapper()
            .configure(WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    @DisplayName("IT - Add post (OK)")
    void addPostTestOK() throws Exception {
        PostDto postDto = new PostDto(6, null, LocalDate.now(), new ProductDto(
                15, "ProductMocked", "TypeMocked", "BrandMocked", "ColorMocked", null
        ), 1, 10.0);
        String payload = objectWriter.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Se agrego exitosamente un nuevo post con el id : 101"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("IT - Add post without product (exception)")
    void addPostTestWithoutProduct() throws Exception {
        PostDto postDto = new PostDto(6, null, LocalDate.now(), new ProductDto(), 1, 10.0);
        String payload = objectWriter.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().is4xxClientError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException ));
    }

    @Test
    @DisplayName("IT - Get Post by Followed Users (OK)")
    void getPostsByFollowedUsers() throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list",2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.posts").exists());
    }
}
