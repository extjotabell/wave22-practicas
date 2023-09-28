package com.meli.be_java_hisp_w22_g01.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w22_g01.dto.response.FollowedDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserFollowersListDTO;
import com.meli.be_java_hisp_w22_g01.dto.response.UserMiniDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US0003 ✅: Obtener un listado de todos los usuarios que siguen a un determinado vendedor")
    void testUS0003() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followers/list";
        int userId = 1;

        ObjectWriter mapper = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

        UserFollowersListDTO expectedResponse = new UserFollowersListDTO(1, "Rick Harrison", List.of(
                new UserMiniDTO(4, "Lisa"),
                new UserMiniDTO(6, "Maggie")
        ));

        String jsonExpectedResponse = mapper.writeValueAsString(expectedResponse);


        // ACT & ASSERT
        mockMvc.perform(get(endpoint, userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonExpectedResponse))
                .andDo(print());
    }

    @Test
    @DisplayName("US0003 🚫: Usuario no existe")
    void testUS0003Fail() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followers/list";
        int userId = 400;

        // ACT & ASSERT
        mockMvc.perform(get(endpoint, userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message[0]").value("El usuario no existe"))
                .andDo(print());
    }

    @Test
    @DisplayName("US0004 ✅: Obtener lista de vendedores que sigue un usuario")
    void testUS0004Ok() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followed/list";
        int userId = 4;

        // ACT & ASSERT
        mockMvc.perform(get(endpoint, userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_name").value("Lisa"))
                .andExpect(jsonPath("$.followed[0].user_name").value("Rick Harrison"))
                .andDo(print());
    }

    @Test
    @DisplayName("US0004 🚫: Usuario no existe")
    void testUS0004Fail() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followed/list";
        int userId = 400;

        // ACT & ASSERT
        mockMvc.perform(get(endpoint, userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message[0]").value("No existe el usuario"))
                .andDo(print());
    }

    @Test
    @DisplayName("US0008 ✅: Ordenamiento alfabético ascendente de US0003")
    void testUS008OK() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followers/list";
        int userId = 1;
        String orderParam = "name_asc";

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        UserFollowersListDTO expectedResponse = new UserFollowersListDTO(1, "Rick Harrison", List.of(
                new UserMiniDTO(4, "Lisa"),
                new UserMiniDTO(6, "Maggie")
        ));


        // ACT
        MvcResult result = mockMvc.perform(get(endpoint, userId).param("order", orderParam))
                .andDo(print())
                .andReturn();
        MockHttpServletResponse response = result.getResponse();

        // ASSERT
        int statusResult = response.getStatus();
        String contentTypeResult = response.getContentType();
        UserFollowersListDTO bodyResult = mapper.readValue(response.getContentAsString(), UserFollowersListDTO.class);

        assertEquals(HttpStatus.OK.value(), statusResult);
        assertEquals(MediaType.APPLICATION_JSON.toString(), contentTypeResult);
        assertEquals(expectedResponse, bodyResult);
    }
    @Test
    @DisplayName("US0008 ✅: Ordenamiento alfabético descendente de US0003")
    void testUS008OK2() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followers/list";
        int userId = 1;
        String orderParam = "name_desc";

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        UserFollowersListDTO expectedResponse = new UserFollowersListDTO(1, "Rick Harrison", List.of(
                new UserMiniDTO(6, "Maggie"),
                new UserMiniDTO(4, "Lisa")
        ));


        // ACT
        MvcResult result = mockMvc.perform(get(endpoint, userId).param("order", orderParam))
                .andDo(print())
                .andReturn();
        MockHttpServletResponse response = result.getResponse();

        // ASSERT
        int statusResult = response.getStatus();
        String contentTypeResult = response.getContentType();
        UserFollowersListDTO bodyResult = mapper.readValue(response.getContentAsString(), UserFollowersListDTO.class);

        assertEquals(HttpStatus.OK.value(), statusResult);
        assertEquals(MediaType.APPLICATION_JSON.toString(), contentTypeResult);
        assertEquals(expectedResponse, bodyResult);
    }

    @Test
    @DisplayName("US0008 🚫: Ordenamiento inexistente de US0003")
    void testUS008Fail() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followers/list";
        int userId = 1;
        String orderParam = "fake_name";

        // ACT & ASSERT
        mockMvc.perform(get(endpoint, userId).param("order", orderParam))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message[0]").value("No existe ese método de ordenamiento"))
                .andDo(print());

    }

    @Test
    @DisplayName("US0008 ✅: Ordenamiento alfabético ascendente de US0004")
    void testUS008OK3() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followed/list";
        int userId = 4;
        String orderParam = "name_asc";

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        FollowedDTO expectedResponse = new FollowedDTO(4, "Lisa", List.of(
                new UserMiniDTO(3, "Comefulanito"),
                new UserMiniDTO(1, "Rick Harrison")
        ));


        // ACT
        MvcResult result = mockMvc.perform(get(endpoint, userId).param("order", orderParam))
                .andDo(print())
                .andReturn();
        MockHttpServletResponse response = result.getResponse();

        // ASSERT
        int statusResult = response.getStatus();
        String contentTypeResult = response.getContentType();
        FollowedDTO bodyResult = mapper.readValue(response.getContentAsString(), FollowedDTO.class);

        assertEquals(HttpStatus.OK.value(), statusResult);
        assertEquals(MediaType.APPLICATION_JSON.toString(), contentTypeResult);
        assertEquals(expectedResponse, bodyResult);
    }
    @Test
    @DisplayName("US0008 ✅: Ordenamiento alfabético descendente de US0004")
    void testUS008OK4() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followed/list";
        int userId = 4;
        String orderParam = "name_desc";

        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        FollowedDTO expectedResponse = new FollowedDTO(4, "Lisa", List.of(
                new UserMiniDTO(1, "Rick Harrison"),
                new UserMiniDTO(3, "Comefulanito")
        ));


        // ACT
        MvcResult result = mockMvc.perform(get(endpoint, userId).param("order", orderParam))
                .andDo(print())
                .andReturn();
        MockHttpServletResponse response = result.getResponse();

        // ASSERT
        int statusResult = response.getStatus();
        String contentTypeResult = response.getContentType();
        FollowedDTO bodyResult = mapper.readValue(response.getContentAsString(), FollowedDTO.class);

        assertEquals(HttpStatus.OK.value(), statusResult);
        assertEquals(MediaType.APPLICATION_JSON.toString(), contentTypeResult);
        assertEquals(expectedResponse, bodyResult);
    }

    @Test
    @DisplayName("US0008 🚫: Ordenamiento inexistente de US0004")
    void testUS008Fail2() throws Exception {
        // ARRANGE
        String endpoint = "/users/{userId}/followed/list";
        int userId = 4;
        String orderParam = "fake_name";

        // ACT & ASSERT
        mockMvc.perform(get(endpoint, userId).param("order", orderParam))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message[0]").value("No existe ese método de ordenamiento"))
                .andDo(print());

    }
}
