package com.example.be_java_hisp_w22_g02.integrationTests;

import com.example.be_java_hisp_w22_g02.dto.request.PostDTO;
import com.example.be_java_hisp_w22_g02.dto.request.ProductDto;
import com.example.be_java_hisp_w22_g02.dto.response.TwoWeeksPostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.SerializationFeature.WRAP_ROOT_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTests {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule()).writer();

    @Test
    public void Get_LastTwoWeeksPostByUserFollowed_OK() throws Exception{
        mockMvc.perform(get("/products/followed/{userId}/list", 1).queryParam("order", "date_asc"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void Get_LastTwoWeeksPostByUserFollowed_BadRequest() throws Exception{
        mockMvc.perform(get("/products/followed/{userId}/list", 1).queryParam("order", "hello"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    @Test
    public void Post_AddNewPost_OK() throws Exception{
        ProductDto productDto = new ProductDto(1, "remera", "ropa", "marca", "negro", null);
        PostDTO postDTO = new PostDTO(1, 1, LocalDate.now() , productDto, 1, 10.0);

        String payloadJson = writer.writeValueAsString(postDTO);
        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void Post_AddNewPost_BadRequest() throws Exception{
        ProductDto productDto = new ProductDto(1, "remera", "ropa", "marca", "negro", null);
        PostDTO postDTO = new PostDTO(1, 0, LocalDate.now() , productDto, 1, 10.0);

        String payloadJson = writer.writeValueAsString(postDTO);
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
