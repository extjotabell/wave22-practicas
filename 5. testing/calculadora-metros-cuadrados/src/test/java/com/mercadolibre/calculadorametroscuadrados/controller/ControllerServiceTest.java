package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerServiceTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer= new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();


    @Test
    public void calculate() throws Exception {
        //Arrange

        HouseResponseDTO expected = new HouseResponseDTO();

        RoomDTO room1 = new RoomDTO();
        room1.setName("cuarto 1");
        room1.setWidth(2);
        room1.setLength(2);
        List<RoomDTO> rooms=new ArrayList<>();
        rooms.add(room1);

        HouseDTO param = new HouseDTO();
        param.setName("Casa");
        param.setAddress("hola 123");
        param.setRooms(rooms);

        expected.setPrice(3200);
        expected.setBiggest(room1);
        expected.setRooms(rooms);
        expected.setName("Casa");
        expected.setAddress("hola 123");
        expected.setSquareFeet(4);

        //Request
        String payloadJson = this.writer.writeValueAsString(param);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson);

        //expected

        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andDo(MockMvcResultHandlers.print());

        }
}
