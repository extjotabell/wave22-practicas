package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.utils.ObjectFactoryHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class FindControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    FindService findService;
    static ObjectMapper mapper;

    @BeforeAll
    static void setUp(){
        mapper = new ObjectMapper();
    }

    @Test
    void find_testOk() throws Exception {
        List<CharacterDTO> sampleCharacters = ObjectFactoryHelper.createSampleCharacterList();

        String jsonInput = mapper.writeValueAsString(sampleCharacters);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInput))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();

        List<CharacterDTO> response = mapper.readValue(jsonResponse, new TypeReference<List<CharacterDTO>>(){});

        assertNotNull(response);
    }
}
