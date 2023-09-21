package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    @Autowired
    FindService findService;

    private List<CharacterDTO> charactersMock;

    @BeforeEach
    void setUp() {
        charactersMock = new ArrayList<>();
        charactersMock.add(new CharacterDTO(
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
        ));
    }

    @Test
    void find() {
        //Arrange
        String query = "Darth Maul";

        //Act
        lenient().when(characterRepository.findAllByNameContains(query)).thenReturn(charactersMock);
        List<CharacterDTO> characterDTOS = findService.find(query);

        //Assert
        assertFalse(characterDTOS.isEmpty());
    }
}