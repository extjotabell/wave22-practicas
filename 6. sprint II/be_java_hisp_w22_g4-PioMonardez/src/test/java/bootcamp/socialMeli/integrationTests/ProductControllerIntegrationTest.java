package bootcamp.socialMeli.integrationTests;

import bootcamp.socialMeli.dto.PostDto;
import bootcamp.socialMeli.dto.ProductDto;
import bootcamp.socialMeli.exception.BadRequestException;
import bootcamp.socialMeli.exception.NotFoundException;
import bootcamp.socialMeli.utils.ProductOrderListEnum;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    //No se especifica orden, lo ordena por default
    @Test
    @DisplayName("US 06 - Posts by followed users - OK")
    void getPostsByFollowedUsersTestOk() throws Exception
    {
        mockMvc.perform(get("/products/followed/2/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id")
                        .value(2))
                .andReturn();
    }

    @Test
    @DisplayName("US 06 - Posts by followed users ordered by desc - OK")
    void getPostsByFollowedUsersTestOrderDescOk() throws Exception
    {
        mockMvc.perform(get("/products/followed/2/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", ProductOrderListEnum.date_desc.name()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id")
                        .value(2))
                .andReturn();
    }

    @Test
    @DisplayName("US 06 - Posts by followed users ordered by asc - OK")
    void getPostsByFollowedUsersTestOrderAscOk() throws Exception
    {
        mockMvc.perform(get("/products/followed/2/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", ProductOrderListEnum.date_asc.name()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id")
                        .value(2))
                .andReturn();
    }

    @Test
    @DisplayName("US 06 - Posts by followed users - User Not Found")
    void getPostsByFollowedUsersTestFailUserNotFound() throws Exception
    {

        mockMvc.perform(get("/products/followed/80/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("User with ID #80 not found"))
                .andExpect(content().contentType("application/json"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof NotFoundException))
                .andReturn();
    }

    @Test
    @DisplayName("US 06 - Posts by followed users - Invalid param, Argument type is invalid")
    void getPostsByFollowedUsersTestFailOrderParamInvalid() throws Exception
    {
        mockMvc.perform(get("/products/followed/2/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("order", "prueba"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message")
                        .value("Argument type is invalid"))
                .andExpect(content().contentType("application/json"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof MethodArgumentTypeMismatchException))
                .andReturn();
    }

    @Test
    @DisplayName("US 05 - Add post - OK")
    void addPostTestOk() throws Exception
    {
        PostDto postDto = new PostDto(1, null, LocalDate.now(), new ProductDto(
                100, "Joystick", "Joystick", "Microsoft", "Blanco", "Joystick xbox"),
                33, 560.00);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Se agrego exitosamente un nuevo post con el id : 101"))
                .andReturn();
    }

    @Test
    @DisplayName("US 05 - Add post - User Not Found")
    void addPostTestFailUserNotFound() throws Exception
    {
        PostDto postDto = new PostDto(80, null, LocalDate.now(), new ProductDto(
                100, "Joystick", "Joystick", "Microsoft", "Blanco", "Joystick xbox"),
                33, 560.00);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("User with ID #80 not found"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof NotFoundException))
                .andReturn();
    }

    @Test
    @DisplayName("US 05 - Add post - Incorrect userId field in payload")
    void addPostTestFailIncompletePayloadEmptyUserId() throws Exception
    {
        PostDto postDto = new PostDto(null, null, LocalDate.now(), new ProductDto(
                100, "Joystick", "Joystick", "Microsoft", "Blanco", "Joystick xbox"),
                33, 350.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(postDto);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("El  id no puede estar vacío. ;"))
                .andExpect(exception -> assertTrue(exception.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn();
    }
}
