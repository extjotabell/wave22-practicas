package com.personaje.personajedisney;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personaje.personajedisney.Dto.PersonajeDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonajeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void GetPersonajeTest() throws Exception {
        List<PersonajeDto> personajelist = new ArrayList<>(List.of(
                new PersonajeDto("Darth Vader","male","Tatooine","Human",202,136),
                new PersonajeDto("Darth Maul","male","Dathomir","Zabrak",175,80)));

        MvcResult result = mockMvc.perform(get("/personaje/{name}","Darth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        List<PersonajeDto> resultDto = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<PersonajeDto>>() {});

        Assertions.assertEquals(personajelist,resultDto);

    }




}
