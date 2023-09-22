package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

     @Autowired
     MockMvc mockMvc;

     ObjectWriter writer= new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

     @Test
     public void getFind() throws Exception{
          //Arrange
          List<CharacterDTO> characterDTOSExpected = new ArrayList<>();
          CharacterDTO characterDTO = new CharacterDTO();
          characterDTO.setName("Luke Skywalker");
          characterDTO.setHeight(172);
          characterDTO.setMass(77);
          characterDTO.setHair_color("blond");
          characterDTO.setSkin_color("fair");
          characterDTO.setEye_color("blue");
          characterDTO.setBirth_year("19BBY");
          characterDTO.setGender("male");
          characterDTO.setHomeworld("Tatooine");
          characterDTO.setSpecies("Human");

          characterDTOSExpected.add(characterDTO);

          String name = "Luke";

          //La request
          MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}", name);

          //Expected

          ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(characterDTOSExpected));

          mockMvc.perform(request)
                  .andExpect(contentExpected)
                  .andDo(MockMvcResultHandlers.print());
     }


}
