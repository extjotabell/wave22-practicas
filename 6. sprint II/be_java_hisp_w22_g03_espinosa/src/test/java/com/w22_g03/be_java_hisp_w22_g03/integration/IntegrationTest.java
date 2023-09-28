package com.w22_g03.be_java_hisp_w22_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.w22_g03.be_java_hisp_w22_g03.dto.PostDTO;
import com.w22_g03.be_java_hisp_w22_g03.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.runtime.ObjectMethods;
import java.time.LocalDate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addProduct() throws Exception {

        ProductDTO productDto = new ProductDTO();
        productDto.setProductId(1L);
        productDto.setName("Producto de ejemplo");
        productDto.setType("tipoEjemplo");
        productDto.setBrand("Marca");
        productDto.setColor("Rojo");
        productDto.setNotes("Notas sobre el producto");

        PostDTO postDto = new PostDTO(); // No se pasa id de usuario ya que este no lleva en el add
        postDto.setUserId(2L);
        postDto.setDate(LocalDate.now());
        postDto.setProduct(productDto);
        postDto.setCategory(3);
        postDto.setPrice(100.0);


        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // arreglamos el tema de que al ObjectMapper no le gusta el localDate

        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(postDto)))
                .andExpect(status().isOk())
                .andDo(print());

    }


}
