package com.example.be_java_hisp_w22_g05.controller;

import com.example.be_java_hisp_w22_g05.dto.PostDto;
import com.example.be_java_hisp_w22_g05.dto.ProductDto;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule()).writer();

    /**
     * Integration test to successfully save a new post
     */
    @Test
    @DisplayName("Nuevo post OK")
    void savePostOk() throws Exception {

        ProductDto productDto = new ProductDto(5, "Name", "Type", "Brand", "Color", "Notes");

        PostDto input = new PostDto(1, 1, LocalDate.now(), productDto, 10, 2500.00, false, null);

        String payload = writer.writeValueAsString(input);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print()).andExpect(status().isOk());

    }

    /**
     * Integration test for when a user tries to save a new post with validation errors
     */
    @Test
    @DisplayName("Post error validaciones")
    void savePostValidationError() throws Exception{
        ProductDto productDto = new ProductDto(1, "Name", "TypeTypeTypeType", "Brand", "Color", "N/t&s");
        PostDto input = new PostDto(1, 0, null, productDto, 0, 11000000.00, false, null);

        List<String> errorList = new ArrayList<>();
        errorList.add("El id debe ser mayor a 0");
        errorList.add("La fecha no puede estar vacia");
        errorList.add("El precio maximo por producto no puede ser mayor a 10.000.000");
        errorList.add("La longitud no puede superar los 15 caracteres");
        errorList.add("El campo no puede poseer caracteres especiales");

        String payload = writer.writeValueAsString(input);
        JSONParser jsonParser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
        JSONArray jsonErrorList = (JSONArray) jsonParser.parse(writer.writeValueAsString(errorList));

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.messages").value(Matchers.containsInAnyOrder(jsonErrorList.toArray())));
    }

    /**
     * Integration test for when a user tries to save a post with an existing product id
     */
    @Test
    @DisplayName("Post id producto ya existe")
    void savePostProductExists() throws Exception {
        ProductDto productDto = new ProductDto(1, "Name", "Type", "Brand", "Color", "Notes");

        PostDto input = new PostDto(1, 1, LocalDate.now(), productDto, 10, 2500.00, false, null);

        String payload = writer.writeValueAsString(input);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El producto con id " + productDto.getId() + " ya existe"));
    }


}
