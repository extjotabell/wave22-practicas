package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService findService;
    @InjectMocks
    FindController findController;

    @Test
    void findOkTest() throws Exception
    {
        //ARRANGE
        List<CharacterDTO> database = List.of(
                new CharacterDTO("Luke Skywalker","blond", "fair", "blue",
                        "19BBY","male","Tatooine", "Human", 172, 77),
                new CharacterDTO("C-3PO","NA","gold","yellow",
                        "112BBY","NA","Tatooine","Droid",167, 75)
        );
        List<CharacterDTO> chatacters = database.stream().filter(c -> Objects.equals(c.getName(), "Luke")).collect(Collectors.toList());

        //ACT
        when(findService.find("Luke")).thenReturn(chatacters);
        List<CharacterDTO> expected =findController.find("Luke");

        //ASSERT
        assertEquals(expected, chatacters);
    }
}
