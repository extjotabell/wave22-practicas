package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

//    @GetMapping("/{query}")
//    public List<CharacterDTO> find(@PathVariable String query) {
//        return findService.find(query);
//    }

    @Test
    void findTestOk() throws Exception {

        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setHeight(202);
        darthVader.setMass(136);
        darthVader.setHair_color("none");
        darthVader.setSkin_color("white");
        darthVader.setEye_color("yellow");
        darthVader.setBirth_year("41.9BBY");
        darthVader.setGender("male");
        darthVader.setHomeworld("Tatooine");
        darthVader.setSpecies("Human");

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        darthMaul.setHeight(175);
        darthMaul.setMass(80);
        darthMaul.setHair_color("none");
        darthMaul.setSkin_color("red");
        darthMaul.setEye_color("yellow");
        darthMaul.setBirth_year("54BBY");
        darthMaul.setGender("male");
        darthMaul.setHomeworld("Dathomir");
        darthMaul.setSpecies("Zabrak");

        List<CharacterDTO> expected = List.of(
                darthVader,
                darthMaul
        );

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(get("/Darth"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(expected)))
                .andDo(print());
    }
}
