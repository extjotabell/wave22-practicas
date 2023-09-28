package com.meli.be_java_hisp_w22_g01.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w22_g01.dto.PostDTO;
import com.meli.be_java_hisp_w22_g01.dto.ProductDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {


    @Autowired
    MockMvc mockMvc;

    private static PostDTO postDTO;

    @BeforeAll
    private static void init(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(112);
        productDTO.setProduct_name("El Terreneitor");
        productDTO.setType("Autos");
        productDTO.setBrand("Terreneitor");
        productDTO.setColor("Azul");
        productDTO.setNotes("El coche ms poderoso que ah existido con traccion 4X4");

        ProductControllerTest.postDTO = new PostDTO();
        postDTO.setUser_id(1);
        postDTO.setDate(LocalDate.now());
        postDTO.setCategory(120);
        postDTO.setPrice(1303);
        postDTO.setProduct(productDTO);
    }


    /**
     * Testeo endpoint /followed/{userId}/list para vendedor inexistente
     * @throws Exception
     */
    @Test
    @DisplayName("Mostrando los seguidores de un usuario inexistente")
    void followedListNotFoundTest() throws Exception{

        int idUser = 1;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/followed/{userId}/list",idUser);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Testeo de endpoint /followed/{userId}/list para vendedor existente
     * @throws Exception
     */
    @Test
    @DisplayName("Mostrando los seguidores de un vendedor existente")
    void followedListOk() throws Exception{

        int idUser = 4;

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/followed/{userId}/list", idUser);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }



    /**
     * Testeo endpoint /followed/{userId}/list para vendedor existente
     * ordenando de forma ascendente
     * @throws Exception
     */
    @Test
    @DisplayName("Ordenando los datos de forma ascendente")
    void followedListOrderAscOKTest() throws Exception{

        int idUser = 4;
        String order = "date_asc";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/followed/{userId}/list",idUser)
                .param("order",order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Testeo endpoint /followed/{userId}/list para vendedor existente
     * ordenando de forma descendente
     * @throws Exception
     */
    @Test
    @DisplayName("Ordenando los datos de forma descendente")
    void followedListOrderDescOKTest() throws Exception{

        int idUser = 4;
        String order = "date_desc";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/followed/{userId}/list",idUser)
                .param("order",order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.user_id").value(idUser);

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Testeo endpoint /followed/{userId}/list para vendedor existente
     * con un ordenamiento inexistente
     * @throws Exception
     */
    @Test
    @DisplayName("Ordenando los datos con una forma inexistente")
    void followedListOrderErrorTest() throws Exception{

        int idUser = 4;
        String order = "asc";

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/followed/{userId}/list",idUser)
                .param("order",order);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentBody = MockMvcResultMatchers.jsonPath("$.message").value("No existe ese método de ordenamiento");

        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentBody)
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * Crea un post con datos validos
     * @throws Exception
     */
    @Test
    @DisplayName("Creando un post valido")
    void createPostTestOk() throws Exception{

        //Seteando usuario correcto
        ProductControllerTest.postDTO.setUser_id(1);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String playload = writer.writeValueAsString(ProductControllerTest.postDTO);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                                .content(playload);


        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andDo(MockMvcResultHandlers.print());
    }


    /**
     * Intenta crear un post con un usuario incorrecto
     * @throws Exception
     */
    @Test
    @DisplayName("Creando un post erroneo")
    void createPostErrorUserTest() throws Exception{

        // Seteando usuario incorrecto
        ProductControllerTest.postDTO.setUser_id(110);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String playload = writer.writeValueAsString(ProductControllerTest.postDTO);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(playload);


        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andDo(MockMvcResultHandlers.print());
    }



    /**
     * Intenta crear un post con un usuario cero
     * @throws Exception
     */
    @Test
    @DisplayName("Creando un post erroneo con usuario cero")
    void createPostErrorUserZeroTest() throws Exception{

        // Seteando usuario incorrecto
        ProductControllerTest.postDTO.setUser_id(0);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String playload = writer.writeValueAsString(ProductControllerTest.postDTO);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(playload);


        mockMvc.perform(requestBuilder)
                .andExpect(statusExpected)
                .andDo(MockMvcResultHandlers.print());
    }

}
