package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Find;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findOK() {
        //Arrange
        CharacterDTO characterDTOmock = new CharacterDTO(
                "Darth Maul",
                "none",
                "red",
                "yellow",
                "54BBY",
                "male",
                "Dathomir",
                "Zabrak",
                175,
                80
        );
        String query = "Darth Maul";
        List<CharacterDTO> expected = List.of(characterDTOmock);
        //Act
        when(findService.find(query)).thenReturn(expected);
        List<CharacterDTO> result = this.findController.find(query);
        //Assert
        assertThat(result, is(expected));
    }
}