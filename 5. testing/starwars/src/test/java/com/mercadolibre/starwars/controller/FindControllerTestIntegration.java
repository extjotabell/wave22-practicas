package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    void findTest() throws Exception {
        // Arrange
        String query = "Luke Skywalker"; // Establece el valor de búsqueda

        // Crea un objeto CharacterDTO que representa a Luke Skywalker con sus atributos
        CharacterDTO lukeSkywalker = new CharacterDTO("Luke Skywalker","blond", "fair","blue","19BBY", "male","Tatooine", "Human", 172, 77);

        // Configura un ObjectWriter (parte de ObjectMapper) para convertir objetos a JSON
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false) // Configura el mapper para no envolver el valor raíz
                .writer();

        // Convierte el objeto lukeSkywalker a JSON y almacena el resultado en expectedJsonResponse
        String expectedJsonResponse = mapper.writeValueAsString(List.of(lukeSkywalker));

        // Act
        // Realiza una solicitud GET al controlador usando el valor de búsqueda en la URL ("/{query}")
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print()) // Imprime la salida de la solicitud (puede ser útil para depuración)
                .andExpect(content().contentType("application/json")) // Verifica que el tipo de contenido de la respuesta sea JSON
                .andExpect(status().isOk()) // Verifica que el código de estado de la respuesta sea 200 (OK)
                .andReturn();

        // Assert
        // Compara el JSON esperado (expectedJsonResponse) con el JSON de la respuesta obtenida
        Assertions.assertEquals(expectedJsonResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void findEmptyTest() throws Exception {
        mockMvc.perform(get("/{query}","XXXX"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

}
